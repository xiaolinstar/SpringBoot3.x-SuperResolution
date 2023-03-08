package com.xiaolin.superresolution.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author xlxing
 */
public class JwtTokenFilter extends OncePerRequestFilter {
    private final String TOKEN_PREFIX = "Bearer ";
    private final String HEADER_STRING = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            throw new ServletException("Missing Authorization header");
        } else {
            String token = header.replace(TOKEN_PREFIX, "");
            try {
                // 在这里执行身份验证逻辑
                // 如果身份验证失败，可以抛出异常或直接设置响应状态
                // 如果身份验证成功，可以将用户信息保存在请求上下文中，以供后续使用
                System.out.println("token "+token);
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }
}
