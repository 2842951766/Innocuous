package com.workAttendance.controller;

import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.UserDao;
import com.workAttendance.service.Pc_casesummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "Pc_casesummaryController")
@RequestMapping("/pc_casesummary")
public class Pc_casesummaryController {


    @Autowired
    private Pc_casesummaryService pc_casesummaryService;

    //用户发起报案请求
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/reportCase")
    @ResponseBody
    public Object reportCase(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        return pc_casesummaryService.reportCase(parametes);

    }

//    根据案件编号查询案件信息
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/selectCaseBycaseNo")
    @ResponseBody
    public Object selectCaseBycaseNo(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        return pc_casesummaryService.selectCaseBycaseNo(parametes);
    }

}
