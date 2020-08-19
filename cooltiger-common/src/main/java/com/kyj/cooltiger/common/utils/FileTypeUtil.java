package com.kyj.cooltiger.common.utils;

/**
 * @author liduan
 * Description: 判断文件类型工具类
 * date: 2020/8/19 11:57
 */
public class FileTypeUtil {

    /**
     * 根据文件名后缀判断文件是否为图片
     *
     * @param fileName
     * @return
     */
    public static boolean isImageByName(String fileName) {
        boolean temp = false;
        if (fileName.endsWith(".jpg") || fileName.endsWith(".png") ||
                fileName.endsWith(".gif") || fileName.endsWith(".bmp")) {
            temp = true;
        }
        return temp;
    }
}
