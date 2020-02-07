package com.workAttendance.dao.impl;

import com.workAttendance.dao.PackagingDao;
import com.workAttendance.dao.Pc_applicationDao;
import com.workAttendance.entity.Packaging;
import com.workAttendance.entity.Pc_application;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "pc_applicationDao")
public class Pc_applicationDaoImpl extends HibernateDaoImplORE<Pc_application> implements Pc_applicationDao {
}
