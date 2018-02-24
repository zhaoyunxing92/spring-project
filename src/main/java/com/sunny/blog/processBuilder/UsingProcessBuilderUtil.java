package com.sunny.blog.processBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunny
 * @className UsingProcessBuilderUtil
 * @date 2018-02-24 15:16
 * @description: java 调用本地命令方法
 * 在J2SE5.0之前使用Runtime的exec方法执行本地命令.
 * 在J2Se5.0之后,可以使用ProcessBuilder执行本地命令
 * 它提供的功能更加丰富,能够设置设置工作目录、环境变量等
 * 关键技术剖析
 * 用本命令名和命令的参数选项构造ProcessBuilder对象,它的start方法执行命令,启动一个进程,返回一个Process对象
 * ProcessBuilder的environment方法获得运行进程的环境变量,得到一个Map,可以修改环境变量
 * ProcessBuilder的directory方法切换工作目录
 */
public class UsingProcessBuilderUtil {
    private final static String VIDEO_PATH = "G:\\迅雷下载\\拱墅视频压缩\\test3(1.5).mp4";

    public static void main(String[] args) {
        cutImgFromVoide(VIDEO_PATH,"10","320*220");
    }

    /**
     * 视频截图
     *
     * @param path
     * @param start
     * @param size
     */
    public static void cutImgFromVoide(String path, String start, String size) {
        List<String> commend = new ArrayList<String>();
        commend.add("ffmpeg");
        commend.add("-y");
        commend.add("-i");
        commend.add(path);
        commend.add("-ss");
        commend.add(start);
        commend.add("-s");
        commend.add(size);
        commend.add("-f");
        commend.add("image2");
        commend.add("-vframes");
        commend.add("1");
        commend.add("I:\\test.jpg");
        
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
          //  builder.redirectErrorStream(true);
            System.out.println("视频截图开始...");
            Process process =builder.start();
            System.out.println("视频截图完成...");
        } catch (IOException e) {
            System.out.println("视频截图异常...");
        }


    }


}
