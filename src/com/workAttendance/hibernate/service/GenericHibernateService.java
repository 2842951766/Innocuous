package com.workAttendance.hibernate.service;

import java.util.List;

public interface GenericHibernateService {

    /**
     * 执行SQL语句并返回结果集合
     * @param tSQLcmd
     * @param pParameter
     * @return
     * @throws Exception
     */
    public List ExecuteQueryByResult(String tSQLcmd, Object... pParameter);

    /**
     * 根据hql查询,直接使用HibernateTemplate的find函数.
     *
     */
    public List find(String hql, Object... values);

    /**
     * 根据hql查询,使用createQuery的分页查询
     *
     */
    public List findByPage(String hql, int limit, int offset, Object... values);

    /**
     * 插入或变更对象
     */
    public void update(Object pObject);

    /**
     * 保存、新建一个对象
     * @param o 对象
     * @param
     */
    public void saveNew(Object o);

    /**
     * 插入或变更对象
     */
    public void saveOrUpdate(Object pObject);

    /**
     * 删除对象
     */
    public void delete(Object pObject);

    /**
     * 执行查询语句,并返回第一列,第一行
     * @param tSQLcmd
     * @param pParameter
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Object ExecuteScalar(String tSQLcmd, Object... pParameter);

    /**
     * 执行SQL语句并返回结果集合
     * @param tSQLcmd
     * @param pParameter
     * @return
     * @throws Exception
     */
    public List ExecuteQueryByResultTrans(String tSQLcmd, Object... pParameter);
}
