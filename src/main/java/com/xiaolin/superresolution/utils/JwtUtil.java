package com.xiaolin.superresolution.utils;

import com.xiaolin.superresolution.model.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author xlxing
 * jwt cookie设置，根据'用户名'获取用户的token，验证token
 * JwtUtil 工具类，在用户登录成功后，主要用于生成 token，并验证用户请求中发送的 token
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {
    private String header;
    private String secret;
    private Long expiration;

    /**
     *     UserDetails是一个接口，使用该方法的类需要实现该接口的所有方法
      */
    public String generateToken(UserDto userDto) {
        Map<String, Object> claims = new HashMap<String, Object>(1);
        return createToken(claims, userDto.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        int expiration = 1000 * 60 * 60 * 5;
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.ES256, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDto userDto) {
        final String username = extractUsername(token);
        return (username.equals(userDto.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
