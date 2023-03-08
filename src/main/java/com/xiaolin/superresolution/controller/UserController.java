package com.xiaolin.superresolution.controller;

import com.xiaolin.superresolution.model.dto.ImageDto;
import com.xiaolin.superresolution.model.dto.UserDto;
import com.xiaolin.superresolution.service.ImageService;
import com.xiaolin.superresolution.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author xlxing
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final ImageService imageService;
    private final UserService userService;

    public UserController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    /**
     * 用户第一次进入页面，获取cookie
     * @return 返回用户身份唯一标识码，可以是用户id
     */
    @PostMapping("/auth/login")
    public ResponseEntity<String> setCookie(HttpServletResponse response, @RequestBody UserDto userDTO) {
        // 1. 创建新用户
        // 2. 将用户信息存储到数据库中
        // 3. 创建一个cookie，并返回到前端
        String token = userService.getToken(userDTO.getUsername(), userDTO.getPassword());
        return ResponseEntity.ok("Cookie set successfully! " + token);
    }

    @PutMapping("/cookie")
    public ResponseEntity<String> updateCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    // Update the value of the cookie
                    cookie.setValue("Mike");
                    // Set the expiration time (optional)
                    // 1 hour
                    cookie.setMaxAge(3600);
                    // Update the cookie in the response
                    response.addCookie(cookie);
                }
            }
        }
        return ResponseEntity.ok("Cookie update successfully!");
    }

    @GetMapping("/api/hello")
    public String hello() {
        // 这是一个网页测试
        return "Hello";
    }

    /**
     * 上传图像
     * @param imageDto: 用户上传图像的相关信息，
     * @return 标识码
     */
    @PostMapping("/image?action=upload")
    public ResponseEntity<?> uploadOne(@RequestBody ImageDto imageDto) {
        // 获取用户上传图像的base64。
        // 将图像保存到图片文件夹
        // 更新数据库中图像信息。
        // (Optional) 调用设置scale=2，进行图像超分辨率
        return ResponseEntity.ok("上传图像成功");
    }

    /**
     *
     * @param action: download url: /index?action=download
     * @return 下载超分辨率后的图像
     */
    @GetMapping("/image?action=download")
    public ResponseEntity<String> downloadOne(@RequestParam String action, @RequestBody ImageDto imageDto) {
        // - 找到用户上传图像的高分辨率图像
        // - 将图像编码为base64字符串
        // - 向前端返回图像数据
        return ResponseEntity.ok("获取超分辨率图像成功");
    }

    @GetMapping("/image")
    public ResponseEntity<?> setScale(@RequestParam int scale) {
        // 设置超分辨率参数，默认为x2
        // - 执行图像超分辨率
        // - 返回给前端超分辨率图像的
        return ResponseEntity.ok("修改倍率成功");
    }

}
