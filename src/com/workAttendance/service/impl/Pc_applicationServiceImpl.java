package com.workAttendance.service.impl;

import com.workAttendance.entity.Packaging;
import com.workAttendance.entity.Pc_application;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.PackagingService;
import com.workAttendance.service.Pc_applicationService;
import org.springframework.stereotype.Service;

@Service(value = "pc_applicationService")
public class Pc_applicationServiceImpl extends HibernateServiceImpl<Pc_application> implements Pc_applicationService {
    @Override
    public HibernateDao<Pc_application> getHibernateDao() {
        return null;
    }
}
