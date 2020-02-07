package com.workAttendance.dao.impl;

import com.workAttendance.dao.WorkerInfoDao;
import com.workAttendance.entity.WorkerInfo;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "workerInfoDao")
public class WorkerInfoDaoImpl extends HibernateDaoImplORE<WorkerInfo> implements WorkerInfoDao {
}
