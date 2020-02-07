package com.workAttendance.hibernate.service;

import java.io.Serializable;
import java.util.List;

/**
 * 定义service的通用操作
 * @author chencong
 * 2017-1-6
 */
public interface HibernateService<T> {
	public void save(T entity);
	
	public void update(T entity);

	public void saveOrUpdate(T entity);
	
	public void delete(Serializable id);

	public void delete(T entity);

	public T getById(Serializable id);
	
	public List<T> getByHQL(String hql, Object... params);  
	
	public List<T> findAll();  
}
