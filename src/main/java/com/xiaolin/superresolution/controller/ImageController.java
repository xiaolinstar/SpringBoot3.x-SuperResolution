package com.xiaolin.superresolution.controller;

import com.xiaolin.superresolution.config.LogConfig;
import com.xiaolin.superresolution.model.entity.Image;
import com.xiaolin.superresolution.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xlxing
 */
@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("")
    public String test() {
        return "This is a test http request.";
    }


    @PostMapping("")
    public ResponseEntity<?> upload(@RequestParam String action, @RequestBody Image image){
        String t = "upload";
        if (action.equals(t)) {
            try {
                Future<String> future = imageService.superResolution(image);
                // 阻塞执行get方法
                String superBase64Path = future.get();
                return ResponseEntity.ok(superBase64Path);
            } catch (ExecutionException | InterruptedException e) {
                LogConfig.addLog(e.getMessage());
            }
        }
        return ResponseEntity.ok("找不到匹配信息");
    }

}
