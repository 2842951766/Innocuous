package com.workAttendance.hibernate.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 定义DAO的通用操作
 * @author chencong
 * @since 2017-01-6
 * @param <E>
 * @param <PK>
 */
public interface HibernateDao<T> {
	public void save(T entity);

	public void update(T entity);
	
	public void delete(T entity);

	public void delete(Serializable id);

	public List<T> findAll();

	public T findById(Serializable id);
	
	public List<T> findByHQL(final String hql, Object... parameters);
	
	public List<Object> findBySQL(final String sql);
	
	public List<T> pageByHQL(final String hql, int first, int max, Object... parameters);
	
	public void saveOrUpdate(T entity);

	public void saveAll(Collection<T> entities);
	
	public int executeSql(String sql);
	
	public int getHQLCount(String hql, Object... parms);
	
	public int getSQLCount(String sql);
}
