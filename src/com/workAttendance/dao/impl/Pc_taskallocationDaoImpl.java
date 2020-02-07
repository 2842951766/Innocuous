package com.workAttendance.dao.impl;

import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.Pc_taskallocationDao;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.Pc_taskallocation;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "pc_taskallocationDao")
public class Pc_taskallocationDaoImpl extends HibernateDaoImplORE<Pc_taskallocation> implements Pc_taskallocationDao {
}
