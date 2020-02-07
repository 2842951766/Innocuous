package com.workAttendance.hibernate;

import com.workAttendance.hibernate.dao.impl.HibernateDaoImpl;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;

public abstract class HibernateDaoImplORE<T> extends HibernateDaoImpl<T> {
	
	/**
     * @author chencong
     * @date 2019-01-12
	 * 注入HibernateDaoImplS
	 */
	@Resource(name="sessionFactory")
	private SessionFactory childSessionFactory;
	
	@Override
	public SessionFactory getSessionFactory() {
		return childSessionFactory;
	}

	@Override
	public void save(T entity) {
		try{
			Method setCreateTm = this.clazz.getDeclaredMethod("setRecCreTm", Date.class);
			setCreateTm.invoke(entity,new Date());
		}catch (Exception e){}
		super.save(entity);
	}
}
