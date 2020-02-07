package com.workAttendance.dao.impl;

import com.workAttendance.dao.UserDao;
import com.workAttendance.dao.WeiXinAuthorityDao;
import com.workAttendance.entity.User;
import com.workAttendance.entity.WeiXinAuthority;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "weiXinAuthorityDao")
public class WeiXinAuthorityDaoImpl extends HibernateDaoImplORE<WeiXinAuthority> implements WeiXinAuthorityDao {

}
