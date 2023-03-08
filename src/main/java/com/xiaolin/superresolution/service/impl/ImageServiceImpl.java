package com.xiaolin.superresolution.service.impl;

import com.xiaolin.superresolution.config.LogConfig;
import com.xiaolin.superresolution.dao.ImageRepository;
import com.xiaolin.superresolution.model.entity.Image;
import com.xiaolin.superresolution.service.ImageService;
import com.xiaolin.superresolution.utils.ImageConvertBase64;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * @author xlxing
 */
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository todoImageRepository;
    private static final String FILE_INPUT = "upload-images/";
    private static final String FILE_OUTPUT = "super-images/";

    public ImageServiceImpl(ImageRepository todoImageRepository) {
        this.todoImageRepository = todoImageRepository;
    }

    @Override
    public Future<String> superResolution(Image image) {
        // TODO: AsyncResult是已经弃用的类，需要更新
        int scale = image.getScale();
        image.setBase64Path(FILE_INPUT+image.getName());
        image.setSuperBase64Path(FILE_OUTPUT + image.getName());
        boolean success = ImageConvertBase64.base64ToImage(image.getBase64(), image.getBase64Path());

        String pythonCmd = ImageConvertBase64.superShellCommand(image.getBase64Path(), image.getSuperBase64Path(), scale);
        if(success) {
            try {
                // 使用线程休眠来模拟该耗时操作
                LogConfig.addLog(pythonCmd);
                // TODO 这里执行python脚本，图像超分辨率
                Process process = Runtime.getRuntime().exec(pythonCmd);
                int status = process.waitFor();
                if(status == 0) {
                    LogConfig.addLog("程序执行成功 ");
                    String superBase64 = ImageConvertBase64.imageToBase64(image.getSuperBase64Path());
                    image.setSuperBase64(superBase64);
                } else {
                    LogConfig.addLog("程序执行失败");
                }
            } catch (InterruptedException | IOException e) {
                LogConfig.addLog(e.getMessage());
            }
            todoImageRepository.save(image);
            return new AsyncResult<>(image.getSuperBase64());
        } else {
            LogConfig.addLog("保存图像失败...");
            return new AsyncResult<>("图像保存失败...");
        }
    }

}
