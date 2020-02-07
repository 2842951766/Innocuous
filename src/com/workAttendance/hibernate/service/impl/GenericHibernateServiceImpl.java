package com.workAttendance.hibernate.service.impl;

import com.workAttendance.hibernate.dao.GenericHibernateDao;
import com.workAttendance.hibernate.service.GenericHibernateService;

import java.util.List;

public abstract class GenericHibernateServiceImpl implements GenericHibernateService {

    public  abstract GenericHibernateDao getGenericHibernateDao();
    @Override
    public List ExecuteQueryByResult(String tSQLcmd, Object... pParameter) {
       return this.getGenericHibernateDao().ExecuteQueryByResult(tSQLcmd,pParameter);
    }

    @Override
    public List find(String hql, Object... values) {
        return this.getGenericHibernateDao().find(hql,values);
    }

    @Override
    public List findByPage(String hql, int limit,int offset,Object... values) {
        return this.getGenericHibernateDao().find(hql,values);
    }

    @Override
    public void update(Object pObject) {
        this.getGenericHibernateDao().update(pObject);
    }

    @Override
    public void saveNew(Object o) {
        this.getGenericHibernateDao().saveNew(o);
    }

    @Override
    public void saveOrUpdate(Object pObject) {
        this.getGenericHibernateDao().saveOrUpdate(pObject);
    }

    @Override
    public void delete(Object pObject) {
        this.getGenericHibernateDao().delete(pObject);
    }

    @Override
    public Object ExecuteScalar(String tSQLcmd, Object... pParameter) {
        return this.getGenericHibernateDao().ExecuteScalar(tSQLcmd,pParameter);
    }

    @Override
    public List ExecuteQueryByResultTrans(String tSQLcmd, Object... pParameter) {
        return this.getGenericHibernateDao().ExecuteQueryByResultTrans(tSQLcmd,pParameter);
    }
}
