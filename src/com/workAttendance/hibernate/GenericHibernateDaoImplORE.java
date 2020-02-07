package com.workAttendance.hibernate;

import com.workAttendance.hibernate.dao.impl.GenericHibernateDaoImpl;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

public abstract class GenericHibernateDaoImplORE extends GenericHibernateDaoImpl {

    /**
     *
     */
    @Resource(name="sessionFactory")
    private SessionFactory childSessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return childSessionFactory;
    }
}
