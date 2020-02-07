package com.workAttendance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workAttendance.entity.Packaging;
import com.workAttendance.entity.Pc_application;
import com.workAttendance.service.PackagingService;
import com.workAttendance.service.Pc_applicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "Pc_applicationController")
@RequestMapping("/pc_application")
public class Pc_applicationController {
    @Autowired
    private Pc_applicationService pc_applicationService;

    //添加移交单申请记录
    @RequestMapping(value="/insert")
    @ResponseBody
    public Object add(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();;
        try {
            String entStr = parametes.get("entity")[0];
            entStr = java.net.URLDecoder.decode(entStr , "UTF-8");
            Pc_application entity  = mapper.readValue(entStr, Pc_application.class);
            pc_applicationService.save(entity);
        }catch (Exception e){
            return "error";
        }
        return "success";
    }
}
