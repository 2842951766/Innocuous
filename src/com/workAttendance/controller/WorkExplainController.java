package com.workAttendance.controller;

import com.workAttendance.service.WorkExplainService;
import com.workAttendance.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "workExplainController")
@RequestMapping("/workExplain")
public class WorkExplainController {

    @Autowired
    private WorkExplainService workExplainService;


    //    模糊查询
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/select")
    @ResponseBody
    public Object select(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        System.out.println("测试连接！");
        return "";
    }

}
