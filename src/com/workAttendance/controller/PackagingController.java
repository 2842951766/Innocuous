package com.workAttendance.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.workAttendance.entity.Packaging;
import com.workAttendance.service.PackagingService;
import com.workAttendance.service.Pc_casesummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "PackagingController")
@RequestMapping("/packaging")
public class PackagingController {

    @Autowired
    private PackagingService packagingService;

    //添加包装袋记录
    @RequestMapping(value="/insert")
    @ResponseBody
    public Object add(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();;
        try {
            String entStr = parametes.get("entity")[0];
            entStr = java.net.URLDecoder.decode(entStr , "UTF-8");
            Packaging entity  = mapper.readValue(entStr, Packaging.class);
            packagingService.save(entity);
        }catch (Exception e){
            return "error";
        }
        return "success";
    }

}
