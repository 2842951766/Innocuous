package com.workAttendance.controller;

import com.workAttendance.service.Mc_farmmingenterprisesService;
import com.workAttendance.service.PackagingService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "Mc_farmmingenterprisesController")
@RequestMapping("/mc_farmmingenterprises")
public class Mc_farmmingenterprisesController {

    @Autowired
    private Mc_farmmingenterprisesService mc_farmmingenterprisesService;

    //获取备案信息
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/selectByCaseNo")
    @ResponseBody
    public Object selectByCaseNo(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        return JSONObject.fromObject(mc_farmmingenterprisesService.selectByCaseNo(parametes));
    }
}
