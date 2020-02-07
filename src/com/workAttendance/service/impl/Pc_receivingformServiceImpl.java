package com.workAttendance.service.impl;

import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.Pc_receivingformDao;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.Pc_receivingform;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.Pc_casesummaryService;
import com.workAttendance.service.Pc_receivingformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "Pc_receivingformService")
public class Pc_receivingformServiceImpl extends HibernateServiceImpl<Pc_receivingform> implements Pc_receivingformService {


    @Autowired
    @Qualifier(value="pc_receivingformDao")
    private Pc_receivingformDao pc_receivingformDao;

    @Override
    public HibernateDao<Pc_receivingform> getHibernateDao() {
        return pc_receivingformDao;
    }
}
