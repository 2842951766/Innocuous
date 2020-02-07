package com.workAttendance.hibernate.dao.impl;

import com.workAttendance.hibernate.dao.GenericHibernateDao;
import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.lang.reflect.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 定义非泛型下DAO通用的操作实现
 * 尚未实现接口内容.....
 * @author xiaoli.zhan
 * @since 2017-01-6
 *
 */
public class GenericHibernateDaoImpl implements GenericHibernateDao {

    private static final Logger logger = Logger.getLogger(HibernateDaoImpl.class);

    public  Class<T> clazz;

    /**
     * 向DAO层注入SessionFactory
     */
    //@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        logger.info("our session:"+this.getSessionFactory().toString());
        this.sessionFactory = sessionFactory;
    }
    /**
     * 获取当前session
     */
    protected Session getSession(){
        return this.getSessionFactory().getCurrentSession();
    }

    @Override
    public List ExecuteQueryByResult(String tSQLcmd, Object... pParameter) {
        SQLQuery pQuery=this.getSession().createSQLQuery(tSQLcmd);
        for(int iCyc=0;iCyc<pParameter.length;iCyc++)
        {
            if(pParameter[iCyc] instanceof String)
            {
                pQuery.setString(iCyc,(String)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Timestamp)
            {
                pQuery.setTimestamp(iCyc,(Timestamp)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Time)
            {
                pQuery.setTime(iCyc, (Time)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Date)
            {
                //pQuery.setDate(iCyc,new java.sql.Date(((Date)pParameter[iCyc]).getTime()));
                //pQuery.setDate(iCyc,new java.sql.Timestamp(((Date)pParameter[iCyc]).getTime()));
                pQuery.setDate(iCyc, (Date)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Boolean)
            {
                pQuery.setBoolean(iCyc,(Boolean)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Short)
            {
                pQuery.setShort(iCyc,(Short)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Integer)
            {
                pQuery.setInteger(iCyc,(Integer)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Long)
            {
                pQuery.setLong(iCyc,(Long)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Double)
            {
                pQuery.setDouble(iCyc,(Double)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Byte)
            {
                pQuery.setByte(iCyc, (Byte)pParameter[iCyc]);
            }
            else
            {
                pQuery.setParameter(iCyc,pParameter[iCyc]);
            }
        }
        return pQuery.list();

    }

    /**
     * 根据hql查询,直接使用HibernateTemplate的find函数.
     *
     */
    @Override
    public List find(String hql, Object... parms) {
        try{
            Query query = this.getSession().createQuery(hql);

            for(int i=0;parms !=null && i< parms.length;i++)
            {
                query.setParameter(i, parms[i]);
            }
            return query.getResultList();
        }catch(Exception e)
        {
            //System.out.println("zxl:"+e.toString());
            return null;
        }
    }

    @Override
    public List findByPage(String hql,int limit,int offset, Object... parms) {
        try{
            Query query = this.getSession().createQuery(hql);

            query.setFirstResult(offset);
            query.setMaxResults(limit);
            for(int i=0;parms !=null && i< parms.length;i++)
            {
                query.setParameter(i, parms[i]);
            }
            return query.getResultList();
        }catch(Exception e)
        {
            //System.out.println("zxl:"+e.toString());
            return null;
        }
    }

    @Override
    public void update(Object pObject) {
        this.getSession().update(pObject);
    }

    @Override
    public void saveNew(Object o) {
        this.getSession().save(o);
    }

    @Override
    public void saveOrUpdate(Object pObject) {
        this.getSession().saveOrUpdate(pObject);
    }

    @Override
    public void delete(Object pObject) {
        this.getSession().delete(pObject);
    }

    @Override
    public Object ExecuteScalar(String tSQLcmd, Object... pParameter) {
        Object                pReturn=null;
        SQLQuery              pQuery=this.getSession().createSQLQuery(tSQLcmd);
        for(int iCyc=0;iCyc<pParameter.length;iCyc++)
        {
            if(pParameter[iCyc] instanceof String)
            {
                pQuery.setString(iCyc,(String)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Timestamp)
            {
                pQuery.setTimestamp(iCyc,(Timestamp)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Time)
            {
                pQuery.setTime(iCyc, (Time)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Date)
            {
                //pQuery.setDate(iCyc,new java.sql.Date(((Date)pParameter[iCyc]).getTime()));
                //pQuery.setDate(iCyc,new java.sql.Timestamp(((Date)pParameter[iCyc]).getTime()));
                pQuery.setDate(iCyc, (Date)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Boolean)
            {
                pQuery.setBoolean(iCyc,(Boolean)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Short)
            {
                pQuery.setShort(iCyc,(Short)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Integer)
            {
                pQuery.setInteger(iCyc,(Integer)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Long)
            {
                pQuery.setLong(iCyc,(Long)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Double)
            {
                pQuery.setDouble(iCyc,(Double)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Byte)
            {
                pQuery.setByte(iCyc, (Byte)pParameter[iCyc]);
            }
            else
            {
                pQuery.setParameter(iCyc,pParameter[iCyc]);
            }
        }
        List pList=pQuery.list();
        if(pList==null||pList.size()==0||pList.get(0)==null)
        {
            return "";
        }
        pReturn=pList.get(0);
        if(pReturn instanceof Array)
        {
            pReturn=Array.get(pReturn, 0);
        }
        return pReturn;
    }

    @Override
    public List ExecuteQueryByResultTrans(String tSQLcmd, Object... pParameter) {
        Query pQuery=this.getSession().createSQLQuery(tSQLcmd).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        for(int iCyc=0;iCyc<pParameter.length;iCyc++)
        {
            if(pParameter[iCyc] instanceof String)
            {
                pQuery.setString(iCyc,(String)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Timestamp)
            {
                pQuery.setTimestamp(iCyc,(Timestamp)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Time)
            {
                pQuery.setTime(iCyc, (Time)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Date)
            {
                //pQuery.setDate(iCyc,new java.sql.Date(((Date)pParameter[iCyc]).getTime()));
                //pQuery.setDate(iCyc,new java.sql.Timestamp(((Date)pParameter[iCyc]).getTime()));
                pQuery.setDate(iCyc, (Date)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Boolean)
            {
                pQuery.setBoolean(iCyc,(Boolean)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Short)
            {
                pQuery.setShort(iCyc,(Short)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Integer)
            {
                pQuery.setInteger(iCyc,(Integer)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Long)
            {
                pQuery.setLong(iCyc,(Long)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Double)
            {
                pQuery.setDouble(iCyc,(Double)pParameter[iCyc]);
            }
            else if(pParameter[iCyc] instanceof Byte)
            {
                pQuery.setByte(iCyc, (Byte)pParameter[iCyc]);
            }
            else
            {
                pQuery.setParameter(iCyc,pParameter[iCyc]);
            }
        }
        return pQuery.list();
    }
}
