package com.workAttendance.dao.impl;

import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.RoleDao;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.Role;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "pc_casesummaryDao")
public class Pc_casesummaryDaoImpl extends HibernateDaoImplORE<Pc_casesummary> implements Pc_casesummaryDao {
}
