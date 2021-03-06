package com.csj.ceshi.utils;

import java.io.File;
import java.net.URL;

/**
 * @author tobiasy
 * @date 2018/12/12
 */
public class ClassLoaderUtils {

    /**
     * 获取加载下的文件
     *
     * @param fileName
     * @return
     */
    public File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        if (url == null) {
            return null;
        }
        return new File(url.getFile());
    }

    /**
     * 静态获取加载文件
     *
     * @param fileName
     * @return
     */
    public static File getLoaderFile(String fileName) {
        return new ClassLoaderUtils().getFile(fileName);
    }
} 