package com.workAttendance.dao.impl;

import com.workAttendance.dao.UserDao;
import com.workAttendance.dao.WorkAtdcRecordDao;
import com.workAttendance.entity.User;
import com.workAttendance.entity.WorkAtdcRecord;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl extends HibernateDaoImplORE<User> implements UserDao {
}
