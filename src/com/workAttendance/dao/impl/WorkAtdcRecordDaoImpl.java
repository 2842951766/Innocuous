package com.workAttendance.dao.impl;

import com.workAttendance.dao.WorkAtdcRecordDao;
import com.workAttendance.entity.WorkAtdcRecord;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "workAtdcRecordDao")
public class WorkAtdcRecordDaoImpl extends HibernateDaoImplORE<WorkAtdcRecord> implements WorkAtdcRecordDao {
}
