package com.workAttendance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workAttendance.dao.WorkAtdcRecordDao;
import com.workAttendance.entity.User;
import com.workAttendance.entity.WorkAtdcRecord;
import com.workAttendance.entity.WorkerInfo;
import com.workAttendance.service.WorkAtdcRecordService;
import com.workAttendance.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller(value = "workAtdcRecordController")
@RequestMapping("/workAtdcRecord")
public class WorkAtdcRecordController {

    @Autowired
    private WorkAtdcRecordService workAtdcRecordService;

    @Autowired
    @Qualifier(value="workAtdcRecordDao")
    private WorkAtdcRecordDao workAtdcRecordDao;

    //    模糊查询
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/select")
    @ResponseBody
    public Object select(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        System.out.println("测试连接！");
        return "";
    }

    //上班打卡
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/upWork")
    @ResponseBody
    public Object upWork(HttpServletRequest request){
            Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();
        //用户id
        int id;
        //上班时间
        Date upWorkTime;
        //上班地点
        String upWorkSpace;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date now = new Date();
            Date rcvTm = sdf.parse(sdf.format(now));
            id = Integer.parseInt(parametes.get("id")[0]);
            upWorkSpace = java.net.URLDecoder.decode(parametes.get("upWorkSpace")[0]);
            upWorkTime = rcvTm;
            //判断当前打卡日期是否存在
            List<WorkAtdcRecord> workAtdcRecordList = workAtdcRecordService.findByTimeUpWork(sdfTwo.format(now),sdfTwo.format(now),id);
            //如果当前打卡日期不存在，则创建一个打卡记录
            if(workAtdcRecordList.size() <= 0){
                WorkAtdcRecord workAtdcRecord = new WorkAtdcRecord();
                User user = new User();
                user.setUserid(id);
                workAtdcRecord.setUpWorkTime(upWorkTime);
                workAtdcRecord.setUser(user);
                workAtdcRecord.setToday(upWorkTime);
                workAtdcRecord.setUpWorkSpace(upWorkSpace);
                workAtdcRecordService.save(workAtdcRecord);
            }else if(workAtdcRecordList.size()>0){
                //如果打卡记录存在，则在已有的打卡记录上进行修改，默认将最新一次打卡记录记录为最终记录
                String sql = "update workAtdcRecord set upWorkTime = '" + sdf.format(upWorkTime) +"' ,upWorkSpace = '" + upWorkSpace + "' where id = " + workAtdcRecordList.get(0).getId();
                workAtdcRecordDao.executeSql(sql);
            }

        }catch (Exception e){
            return "error";
        }
        return "success";
    }


    //下班打卡
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/downWork")
    @ResponseBody
    public Object downWork(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();
        //用户id
        int id;
        //下班时间
        Date downWorkTime;
        //下班班地点
        String downWorkSpace;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date now = new Date();
            Date rcvTm = sdf.parse(sdf.format(now));
            id = Integer.parseInt(parametes.get("id")[0]);
            downWorkSpace = java.net.URLDecoder.decode(parametes.get("downWorkSpace")[0]);
            downWorkTime = rcvTm;
            //判断当前打卡日期是否存在
            List<WorkAtdcRecord> workAtdcRecordList = workAtdcRecordService.findByTimeUpWork(sdfTwo.format(now),sdfTwo.format(now),id);
            //如果当前打卡日期不存在，则创建一个打卡记录
            if(workAtdcRecordList.size() <= 0){
                WorkAtdcRecord workAtdcRecord = new WorkAtdcRecord();
                User user = new User();
                user.setUserid(id);
                workAtdcRecord.setDownWorkTime(downWorkTime);
                workAtdcRecord.setUser(user);
                workAtdcRecord.setToday(downWorkTime);
                workAtdcRecord.setDownWorkSpace(downWorkSpace);
                workAtdcRecordService.save(workAtdcRecord);
            }else if(workAtdcRecordList.size()>0){
                //如果打卡记录存在，则在已有的打卡记录上进行修改，默认将最新一次打卡记录记录为最终记录
                String sql = "update workAtdcRecord set downWorkTime = '" + sdf.format(downWorkTime) +"' ,downWorkSpace = '" + downWorkSpace + "' where id = " + workAtdcRecordList.get(0).getId();
                workAtdcRecordDao.executeSql(sql);
            }

        }catch (Exception e){
            return "error";
        }
        return "success";
    }

    //外勤打卡
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/outWork")
    @ResponseBody
    public Object outWork(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();
        //用户id
        int id;
        //外勤时间
        Date outWorkTime;
        //外勤地点
        String outWorkSpace;
        //外勤原因
        String outWorkExplain;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date now = new Date();
            Date rcvTm = sdf.parse(sdf.format(now));
            id = Integer.parseInt(parametes.get("id")[0]);
            outWorkSpace = java.net.URLDecoder.decode(parametes.get("outWorkSpace")[0]);
            outWorkExplain = java.net.URLDecoder.decode(parametes.get("outWorkExplain")[0]);
            outWorkTime = rcvTm;
            //判断当前打卡日期是否存在
            List<WorkAtdcRecord> workAtdcRecordList = workAtdcRecordService.findByTimeUpWork(sdfTwo.format(now),sdfTwo.format(now),id);
            //如果当前打卡日期不存在，则创建一个打卡记录
            if(workAtdcRecordList.size() <= 0){
                WorkAtdcRecord workAtdcRecord = new WorkAtdcRecord();
                User user = new User();
                user.setUserid(id);
                workAtdcRecord.setOutWorkExplain(outWorkExplain);
                workAtdcRecord.setOutWorkTime(outWorkTime);
                workAtdcRecord.setToday(outWorkTime);
                workAtdcRecord.setUser(user);
                workAtdcRecord.setOutWorkSpace(outWorkSpace);
                workAtdcRecordService.save(workAtdcRecord);
            }else if(workAtdcRecordList.size()>0){
                //如果打卡记录存在，则在已有的打卡记录上进行修改，默认将最新一次打卡记录记录为最终记录
                String sql = "update workAtdcRecord set outWorkTime = '" + sdf.format(outWorkTime) +"' ,outWorkSpace = '" + outWorkSpace + "' ,outWorkExplain = '"+ outWorkExplain +"' where id = " + workAtdcRecordList.get(0).getId();
                workAtdcRecordDao.executeSql(sql);
            }

        }catch (Exception e){
            return "error";
        }
        return "success";
    }

    //加班打卡
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/overWork")
    @ResponseBody
    public Object overWork(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();
        //用户id
        int id;
        //加班时间
        Date overWorkTime;
        //加班班地点
        String overWorkSpace;
        //加班原因
        String overWorkExplain;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date now = new Date();
            Date rcvTm = sdf.parse(sdf.format(now));
            id = Integer.parseInt(parametes.get("id")[0]);
            overWorkSpace = java.net.URLDecoder.decode(parametes.get("overWorkSpace")[0]);
            overWorkExplain = java.net.URLDecoder.decode(parametes.get("overWorkExplain")[0]);
            overWorkTime = rcvTm;
            //判断当前打卡日期是否存在
            List<WorkAtdcRecord> workAtdcRecordList = workAtdcRecordService.findByTimeUpWork(sdfTwo.format(now),sdfTwo.format(now),id);
            //如果当前打卡日期不存在，则创建一个打卡记录
            if(workAtdcRecordList.size() <= 0){
                WorkAtdcRecord workAtdcRecord = new WorkAtdcRecord();
                User user = new User();
                user.setUserid(id);
                workAtdcRecord.setOutWorkTime(overWorkTime);
                workAtdcRecord.setOverWorkExplain(overWorkExplain);
                workAtdcRecord.setUser(user);
                workAtdcRecord.setToday(overWorkTime);
                workAtdcRecord.setOutWorkSpace(overWorkSpace);
                workAtdcRecordService.save(workAtdcRecord);
            }else if(workAtdcRecordList.size()>0){
                //如果打卡记录存在，则在已有的打卡记录上进行修改，默认将最新一次打卡记录记录为最终记录
                String sql = "update workAtdcRecord set overWorkTime = '" + sdf.format(overWorkTime) +"' ,overWorkSpace = '" + overWorkSpace + "' ,overWorkExplain = '" + overWorkExplain + "'   where id = " + workAtdcRecordList.get(0).getId();
                workAtdcRecordDao.executeSql(sql);
            }

        }catch (Exception e){
            return "error";
        }
        return "success";
    }

    //按时间端查询时间
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/selectByTime")
    @ResponseBody
    public Object selectByTime(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();
        //用户id
        int id ;
        //开始时间
        String firstTime;
        //结束时间
        String endTime;

        try {
            id = Integer.parseInt(parametes.get("id")[0]);
            firstTime = java.net.URLDecoder.decode(parametes.get("firstTime")[0]);
            endTime = java.net.URLDecoder.decode(parametes.get("endTime")[0]);
            List<WorkAtdcRecord> workAtdcRecordList = workAtdcRecordService.findByTimeUpWork(firstTime,endTime,id);
            int size =workAtdcRecordList.size();
            if(size>0){
                WorkAtdcRecord[] m = workAtdcRecordList.toArray(new WorkAtdcRecord[size]);
                return m;
            }else
            {
                WorkAtdcRecord[] m = new WorkAtdcRecord[]{};
                return m;
            }
        }catch (Exception e){
            return "error";
        }
    }

}
