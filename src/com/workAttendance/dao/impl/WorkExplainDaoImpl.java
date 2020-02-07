package com.workAttendance.dao.impl;

import com.workAttendance.dao.WorkExplainDao;
import com.workAttendance.dao.WorkerInfoDao;
import com.workAttendance.entity.WorkExplain;
import com.workAttendance.entity.WorkerInfo;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "workExplainDao")
public class WorkExplainDaoImpl extends HibernateDaoImplORE<WorkExplain> implements WorkExplainDao {
}
