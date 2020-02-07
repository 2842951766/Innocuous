package com.workAttendance.controller;

import com.workAttendance.dao.UserDao;
import com.workAttendance.entity.User;
import com.workAttendance.service.UserService;
import com.workAttendance.service.WorkAtdcRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "UserController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    //认证用户信息
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/checkUserInfo")
    @ResponseBody
    public Object select(HttpServletRequest request){
        Map<String,String[]> parametes = request.getParameterMap();

        return userService.checkUserInfo(parametes);
    }


}
