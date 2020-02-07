package com.workAttendance.controller;

import com.workAttendance.dao.Pc_taskallocationDao;
import com.workAttendance.service.Pc_taskService;
import com.workAttendance.utils.SavePic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller(value = "Pc_taskController")
@RequestMapping("/pc_task")
public class Pc_taskController {


    @Autowired
    @Qualifier(value="pc_taskService")
    private Pc_taskService pc_taskService;

    //    查询我的待办信息
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/selectNeedDealInfo")
    @ResponseBody
    public Object reportCase(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        return pc_taskService.selectNeedDealInfo(parametes);
    }

    //    上传收集现场的图片
    @RequestMapping(value="/testUpLoadPic")
    @ResponseBody
    public Object testUpLoadPic(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        //获取存放收集图片的文件夹名称
        String packageName = parametes.get("packageName")[0];
        HttpServletRequest httpServletRequest = request;

        //        获取当前项目路径(用于存放所有上传的文档)
        String path = request.getSession().getServletContext().getRealPath("");

//        方式file对象存在缓存，导致无法删除
        String target = path+"/collect/" + packageName +"/scene";

//        先删除文件夹下所有文件
//        File file = new File(target);
//        File [] files = file.listFiles();
//        for(File tempFile:files){
//            tempFile.delete();
//        }
        return SavePic.UpLoadPic(request,target);

    }

    //查询我办理的案子的现场图片
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/getPic")
    @ResponseBody
    public Object getPic(HttpServletRequest request){
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
}
