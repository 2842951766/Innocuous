package com.workAttendance.service.impl;

import com.workAttendance.dao.WorkerInfoDao;
import com.workAttendance.entity.WorkerInfo;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "workerInfoService")
public class WorkerInfoServiceImpl extends HibernateServiceImpl<WorkerInfo> implements WorkerInfoService {

    @Autowired
    @Qualifier(value="workerInfoDao")
    private WorkerInfoDao workerInfoDao;

    @Override
    public HibernateDao<WorkerInfo> getHibernateDao() {
        return workerInfoDao;
    }
}
