package com.xiaolin.superresolution.utils;

import com.xiaolin.superresolution.config.LogConfig;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

/**
 * @author xlxing
 * description: 图像与base64字符串互相转码工具类
 */
public class ImageConvertBase64{
    /**
     *
     * @param base64 图像的base64编码字符串
     * @param writeName 想要写入的文件名，需要包含文件路径，不需要包含扩展名
     */
    public static boolean base64ToImage(String base64, String writeName) {
        // TODO 需要保存base64的header信息
        LogConfig.addLog("base64ToImage");
        String[] base64str = base64.split(",");
        String head = base64str[0];
        String base64data = base64str[1];
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64data);
            // 获取图像的扩展名
            FileUtils.writeByteArrayToFile(new File(writeName), decodedBytes);
            return true;
            // 存储数据信息到数据库
        } catch (IOException e) {
            LogConfig.addLog(e.getMessage());
            return false;
        }
    }

    /**
     * 图像编码为base64
     * @param filename 图像的路径
     * @return 图像的base64编码
     */
    public static String imageToBase64(String filename) {
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File(filename));
            // TODO 需要加上编码header
            return "data:image/jpg;base64," + Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 图像超分辨率相关的shell命令
     * @return 调用python程序的shell命令
     */
    public static String superShellCommand(String srcPath, String dstPath, int scale) {
        return "python run.py --image %s --super_image %s --scale %d".formatted(srcPath, dstPath, scale);
    }
}
