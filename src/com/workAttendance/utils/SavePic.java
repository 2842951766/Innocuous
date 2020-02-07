package com.workAttendance.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//存储图片工具(接受的图片来自前台)
public class SavePic {

    /**
     *
     * @param request
     * @param target 存放图片的文件夹名称
     * @return
     */
    public static boolean UpLoadPic(HttpServletRequest request,String target){
//        方式file对象存在缓存，导致无法删除
        File fileTwo = new File(target);
        if(!fileTwo.exists()){
            fileTwo.mkdirs();
        }

//        设置编码方式
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, Object> json = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        /** 页面控件的文件流* */
        MultipartFile multipartFile = null;
        Map map = multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
            Object obj = i.next();
            multipartFile = (MultipartFile) map.get(obj);
        }
        String filename = multipartFile.getOriginalFilename();
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;

//        创建输入对象
        File result = new File(fileTwo + "/" +filename);
        if (result.exists()) {
            return false;
        }
        if (!result.exists()) {//如果文件不存在
            try {
                result.createNewFile();//会在磁盘下创建文件，但此时大小为0K
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileOutputStream = new FileOutputStream(result);// 指定要写入的图片
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
//          IO流将文件写入
            inputStream = multipartFile.getInputStream();
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = inputStream.read(bb)) != -1) {
                fileOutputStream.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }fileOutputStream.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }

    /**
     *
     * @param request
     * @param fileName 指定需要创建的文件的名称
     * @param target   指定存放的文件夹
     * @return
     */
    public static boolean UpLoadPic(HttpServletRequest request,String fileName,String target){
//        方式file对象存在缓存，导致无法删除
        File fileTwo = new File(target);
        if(!fileTwo.exists()){
            fileTwo.mkdirs();
        }

//        设置编码方式
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, Object> json = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        /** 页面控件的文件流* */
        MultipartFile multipartFile = null;
        Map map = multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
            Object obj = i.next();
            multipartFile = (MultipartFile) map.get(obj);
        }
//        获取前端文件名称
        String requestFileName = multipartFile.getOriginalFilename();
        String[] tempLast = requestFileName.split("\\.");
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;

//        创建输入对象
        File result = new File(fileTwo + "/" +fileName+"."+tempLast[tempLast.length-1]);

        if (!result.exists()) {//如果文件不存在
            try {
                result.createNewFile();//会在磁盘下创建文件，但此时大小为0K
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileOutputStream = new FileOutputStream(result);// 指定要写入的图片
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
//          IO流将文件写入
            inputStream = multipartFile.getInputStream();
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = inputStream.read(bb)) != -1) {
                fileOutputStream.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }fileOutputStream.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }
}
