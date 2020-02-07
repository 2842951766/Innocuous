package com.workAttendance.hibernate.service.impl;

import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.HibernateService;

import java.io.Serializable;
import java.util.List;

/**
 * 定义service的通用操作的实现
 * @author chencong
 * 2017-1-6
 */
public abstract class HibernateServiceImpl<T> implements HibernateService<T> {
	public  abstract HibernateDao<T> getHibernateDao();
	
	@Override
	public void save(T entity) {
		this.getHibernateDao().save(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateDao().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateDao().saveOrUpdate(entity);
	}

	@Override
	public void delete(Serializable id) {
		this.getHibernateDao().delete(id);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateDao().delete(entity);
	}

	@Override
	public T getById(Serializable id) {
		return this.getHibernateDao().findById(id);
	}

	@Override
	public List<T> getByHQL(String hql, Object... params) {
		return this.getHibernateDao().findByHQL(hql,params);
	}

	@Override
	public List<T> findAll() {
		return this.getHibernateDao().findAll();
	}
}
