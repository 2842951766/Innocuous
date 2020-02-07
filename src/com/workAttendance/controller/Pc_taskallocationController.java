package com.workAttendance.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.workAttendance.dao.Pc_taskallocationDao;
import com.workAttendance.entity.Pc_taskallocation;
import com.workAttendance.service.Pc_casesummaryService;
import com.workAttendance.service.Pc_taskallocationService;
import com.workAttendance.utils.SavePic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller(value = "Pc_taskallocationController")
@RequestMapping("/pc_taskallocation")
public class Pc_taskallocationController {

    @Autowired
    private Pc_taskallocationService pc_taskallocationService;

    @Autowired
    @Qualifier(value="pc_taskallocationDao")
    private Pc_taskallocationDao pc_taskallocationDao;

//    查询我的案件处理信息
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/selectNeedDealInfo")
    @ResponseBody
    public Object reportCase(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        return pc_taskallocationService.selectNeedDealInfo(parametes);
    }

//    拒绝或接受当前任务
    @RequestMapping(value="/updateResponse")
    @ResponseBody
    public Object updateResponse(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
//        查询我的任务分配信息表
        Pc_taskallocation pc_taskallocation = pc_taskallocationService.selectNeedDealInfo(parametes)[0];
        ObjectMapper mapper = new ObjectMapper();
        try {
            String id = parametes.get("id")[0];
//            当前用户的回复状态
            String response = parametes.get("response")[0];
            if(pc_taskallocation.getDriverid() == Integer.parseInt(id)){
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String sql = "update pc_taskallocation set driver_response = " + response + " , driver_time2 =  '" + time + "'  where caseno = '" + pc_taskallocation.getCaseno() + "'";
                String sql2 = "";
                if(response.replace("'","").equals("是")){
                     sql2 = "update pc_task set todo_status =  '处理中' where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }else if(response.replace("'","").equals("否")){
                    sql2 = "update pc_task set todo_status =  '拒绝'  where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }

                pc_taskallocationDao.executeSql(sql);
                pc_taskallocationDao.executeSql(sql2);
            }else if(pc_taskallocation.getSupervisorid()==Integer.parseInt(id)){
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String sql = "update pc_taskallocation set supervisor _response = '" + response + "' , supervisor _time2 = '" + time + "' where caseno = '" + pc_taskallocation.getCaseno() + "'";
                String sql2 = "";
                if(response.replace("'","").equals("是")){
                    sql2 = "update pc_task set todo_status =  '处理中' where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }else if(response.replace("'","").equals("否")){
                    sql2 = "update pc_task set todo_status =  '拒绝'  where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }
                pc_taskallocationDao.executeSql(sql);
                pc_taskallocationDao.executeSql(sql2);
            }else if(pc_taskallocation.getCollectorid() == Integer.parseInt(id)){
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String sql = "update pc_taskallocation set collector _response = '" + response + "' , collector _time2 = '" + time + "' where caseno = '" + pc_taskallocation.getCaseno() + "'";
                String sql2 = "";
                if(response.replace("'","").equals("是")){
                    sql2 = "update pc_task set todo_status =  '处理中' where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }else if(response.replace("'","").equals("否")){
                    sql2 = "update pc_task set todo_status =  '拒绝'  where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }
                pc_taskallocationDao.executeSql(sql);
                pc_taskallocationDao.executeSql(sql2);
            }else if(pc_taskallocation.getInsurersid() == Integer.parseInt(id)){
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String sql = "update pc_taskallocation set insurers _response = '" + response + "' , insurers _time2 = '" + time + "' where caseno = '" + pc_taskallocation.getCaseno() + "'";
                String sql2 = "";
                if(response.replace("'","").equals("是")){
                    sql2 = "update pc_task set todo_status =  '处理中' where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }else if(response.replace("'","").equals("否")){
                    sql2 = "update pc_task set todo_status =  '拒绝'  where caseno =  '" + pc_taskallocation.getCaseno() + "'";
                }
                pc_taskallocationDao.executeSql(sql);
                pc_taskallocationDao.executeSql(sql2);
            };


        }catch (Exception e){
            return "error";
        }
        return "success";
    }



}
