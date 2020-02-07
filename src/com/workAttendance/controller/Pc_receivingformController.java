package com.workAttendance.controller;


import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.workAttendance.entity.Packaging;
import com.workAttendance.entity.Pc_receivingform;
import com.workAttendance.service.Pc_casesummaryService;
import com.workAttendance.service.Pc_receivingformService;
import com.workAttendance.service.RoleService;
import com.workAttendance.utils.CreatePDF.PdfReport;
import com.workAttendance.utils.SavePic;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller(value = "Pc_receivingformController")
@RequestMapping("/pc_receivingform")
public class Pc_receivingformController {

    @Autowired
    private Pc_receivingformService pc_receivingformService;

    @Autowired
    @Qualifier(value="roleService")
    private RoleService roleService;

    //添加接收单记录
    @RequestMapping(value="/insert")
    @ResponseBody
    public Object add(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();
        DeserializationConfig cfg = mapper.getDeserializationConfig();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        //获取存放收集图片的文件夹名称
        String packageName = parametes.get("packageName")[0];
        try {
            String entStr = parametes.get("entity")[0];
            entStr = java.net.URLDecoder.decode(entStr , "UTF-8");
            Pc_receivingform entity  = mapper.readValue(entStr, Pc_receivingform.class);
            entity.setqR_code("test");
            HttpServletRequest httpServletRequest = request;
            //        获取当前项目路径(用于存放所有上传的文档)
            String path = request.getSession().getServletContext().getRealPath("");
//        存放签名图片位置
            String target = path + "/collect/" + packageName + "/sign";
            try {

                File file = new File(target);
                if(!file.exists()){
                    file.mkdirs();
                }
                File[] files = file.listFiles();
                if(files.length<3){
                    return "needSign";
                }
                String [] signs = new String[3];
                for(int index = 0;index<files.length;index++){
                    signs[index] = file.getAbsolutePath() + "/" +files[index].getName();
                }
                //开始生成pdf
                PdfReport.createPDF(path + "/collect/" + packageName + "/signDPF", signs,entity);

            }catch (Exception e){}
            pc_receivingformService.save(entity);
        }catch (Exception e){
            return "error";
        }
        return "success";
    }

    //请求收集现场拍摄的图片
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/getPicScene")
    @ResponseBody
    public Object getPicScene(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        String [] fileName = null;
        try {
                String caseNo =  URLDecoder.decode(parametes.get("caseNo")[0],"utf-8");
            String path = request.getSession().getServletContext().getRealPath("");
            //获取存放收集图片的地址
            path = path + "/collect/" + caseNo+"/scene";
            File file = new File(path);
            fileName = file.list();
            for(int index = 0 ;index<fileName.length;index++){
                fileName[index] ="http://localhost:8080/Innocuous/collect/" + caseNo +"/scene" + "/"+fileName[index];
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    //添加签字图片
    @RequestMapping(value="/sign")
    @ResponseBody
    public Object sign(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        //获取存放收集图片的文件夹名称
        String packageName = parametes.get("packageName")[0];
        int userid = Integer.parseInt(parametes.get("userid")[0]);

//        角色名称
        String roleName = roleService.getRole(userid);

        HttpServletRequest httpServletRequest = request;
        //        获取当前项目路径(用于存放所有上传的文档)
        String path = request.getSession().getServletContext().getRealPath("");
//        存放签名图片位置
        String target = path + "/collect/" + packageName + "/sign";

        return SavePic.UpLoadPic(request,roleName,target);
    }

    //请求签字图片的url
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/getPic")
    @ResponseBody
    public Object getPic(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
//        返回给前台的图片地址
        Map<String,String>  picUrl = new HashMap<String, String>();
        String [] fileName = null;
        try {
            String caseNo =  URLDecoder.decode(parametes.get("caseNo")[0],"utf-8");
            String path = request.getSession().getServletContext().getRealPath("");
            //获取存放收集图片的地址
            path = path + "/collect/" + caseNo.trim()+"/sign";
            File file = new File(path);
            fileName = file.list();
            for(int index = 0 ;index<fileName.length;index++){
                fileName[index] ="http://localhost:8080/Innocuous/collect/" + caseNo.trim()+"/sign" + "/"+fileName[index];
                String[] tempLast = fileName[index].split("\\.|/");
                picUrl.put(tempLast[tempLast.length-2],fileName[index]);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  JSONObject.fromObject(picUrl);
    }


}
