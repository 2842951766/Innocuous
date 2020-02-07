package com.workAttendance.service.impl;

import com.workAttendance.dao.PackagingDao;
import com.workAttendance.entity.Packaging;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.PackagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "packagingService")
public class PackagingServiceImpl extends HibernateServiceImpl<Packaging> implements PackagingService {

    @Autowired
    @Qualifier(value="packagingDao")
    private PackagingDao packagingDao;

    @Override
    public HibernateDao<Packaging> getHibernateDao() {
        return packagingDao;
    }
}
