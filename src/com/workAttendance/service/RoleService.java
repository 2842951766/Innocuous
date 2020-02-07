package com.workAttendance.service;

import com.workAttendance.entity.Role;
import com.workAttendance.entity.User;
import com.workAttendance.hibernate.service.HibernateService;

public interface RoleService extends HibernateService<Role> {
    //根据用户id确定用户是否是报案主体管理员，监管员，收集员其中的一个
    public String getRole(int userid);
}
