package com.workAttendance.service;

import com.workAttendance.entity.User;
import com.workAttendance.entity.WorkAtdcRecord;
import com.workAttendance.hibernate.service.HibernateService;

import java.util.List;
import java.util.Map;

public interface UserService extends HibernateService<User> {
//    验证用户身份，获取用户信息
    public User[] checkUserInfo(Map<String, String[]> parametes);
}
