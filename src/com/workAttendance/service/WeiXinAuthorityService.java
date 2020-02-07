package com.workAttendance.service;

import com.workAttendance.entity.User;
import com.workAttendance.entity.WeiXinAuthority;
import com.workAttendance.hibernate.service.HibernateService;

import java.util.Map;

public interface WeiXinAuthorityService extends HibernateService<WeiXinAuthority> {

    //    查询微信用户菜单权限
    public WeiXinAuthority[] selectWeiXinAuthority(Map<String, String[]> parametes);
}
