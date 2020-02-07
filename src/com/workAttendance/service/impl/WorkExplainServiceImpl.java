package com.workAttendance.service.impl;

import com.workAttendance.dao.WorkExplainDao;
import com.workAttendance.dao.WorkerInfoDao;
import com.workAttendance.entity.WorkExplain;
import com.workAttendance.entity.WorkerInfo;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.WorkExplainService;
import com.workAttendance.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "workExplainService")
public class WorkExplainServiceImpl extends HibernateServiceImpl<WorkExplain> implements WorkExplainService {

    @Autowired
    @Qualifier(value="workExplainDao")
    private WorkExplainDao workExplainDao;

    @Override
    public HibernateDao<WorkExplain> getHibernateDao() {
        return workExplainDao;
    }
}
