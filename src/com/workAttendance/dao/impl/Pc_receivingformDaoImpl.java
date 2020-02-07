package com.workAttendance.dao.impl;

import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.Pc_receivingformDao;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.Pc_receivingform;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "pc_receivingformDao")
public class Pc_receivingformDaoImpl extends HibernateDaoImplORE<Pc_receivingform> implements Pc_receivingformDao {
}
