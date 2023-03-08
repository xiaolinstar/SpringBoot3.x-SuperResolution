package com.xiaolin.superresolution.service;

import com.xiaolin.superresolution.model.entity.Image;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

/**
 * @author xlxing
 */
public interface ImageService {
    /**
     * 根据前端传入的图像，进行图像超分辨率
     * @param image: 图像信息
     * @return 高分辨率图像的base64编码
     */
    @Async("imageThreadPool")
    Future<String> superResolution(Image image);
}
