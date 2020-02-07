package com.workAttendance.controller;

import com.workAttendance.service.UserService;
import com.workAttendance.service.WeiXinAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "WeiXinAuthorityController")
@RequestMapping("/weiXinAuthority")
public class WeiXinAuthorityController {

    @Autowired
    private WeiXinAuthorityService weiXinAuthorityService;

//    查询用户权限
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/selectUserWeiXinAuthority")
    @ResponseBody
    public Object selectUserWeiXinAuthority(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();
        return weiXinAuthorityService.selectWeiXinAuthority(parametes);
    }
}
