/**
 * HibernateTDao.java
 */
package com.workAttendance.hibernate.dao.impl;

import com.workAttendance.hibernate.dao.HibernateDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.Collection;
import java.util.List;

/**
 * 定义DAO通用的操作实现
 * @author xiaoli.zhan
 * 2017-1-6
 * 泛型HibernateDao
 */
public abstract class HibernateDaoImpl<T> implements HibernateDao<T> {
//public  class HibernateDaoImpl <T>  implements HibernateDao<T> {
	private static final Logger logger = Logger.getLogger(HibernateDaoImpl.class);
	
	public  Class<T> clazz;

	/**
	 * 通过构造方法指定DAO的具体实现类
	 */
	@SuppressWarnings("unchecked")
	public HibernateDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		logger.info("DAO真实实现类为:" + this.clazz.getName());  
	} 
	 
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
		//return this.sessionFactory.getCurrentSession();
		return this.getSessionFactory().getCurrentSession();
		//return this.sessionFactory.openSession();
		//return this.getSessionFactory().openSession();
	}

	//以下为实现方法
	@Override
	public void save(T entity) {
		this.getSession().save(entity);
		/*Session session = this.getSession();
		try {
			session.save(entity);
			//session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != session) {
			try {
				session.close();
			} catch (Exception ex) {
			}
		}*/
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void delete(Serializable id) {
		this.getSession().delete(this.findById(id));
	}

	@Override
	public List<T> findAll() {
		return this.findByHQL("from " + this.clazz.getName());
	}

	@Override
	public T findById(Serializable id) {
		return this.getSession().get(this.clazz, id);
	}

	@Override
	public List<T> findByHQL(String hql, Object... parms) {
		try{
			Query<T> query = this.getSession().createQuery(hql,this.clazz);
			
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
	public List<Object> findBySQL(String sql) {
		try{
			@SuppressWarnings("unchecked")
			List<Object> list = this.getSession().createNativeQuery(sql).getResultList();
			
			return list;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> pageByHQL(final String hql, int first, int max, Object... parms){
		try{
			Query<T> query = this.getSession().createQuery(hql,this.clazz);
			
			for(int i=0;parms !=null && i< parms.length;i++)
			{
				query.setParameter(i, parms[i]);
			}
			//分页
			query.setFirstResult(first); 
			query.setMaxResults(max); 
			return query.getResultList();
		}catch(Exception e)
		{
			return null;
		}
	}
	
	@Override
	public void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}

	@Override
	public void saveAll(Collection<T> entities) {
		if(entities != null)
			for(T it : entities)
				this.save(it);
//		for(Iterator<T> it = entities.iterator();it.hasNext();){
//			this.save(it.next());
//		}
	}
	
	@Override
	public int executeSql(String sql) {
		/*return this.getSession().createNativeQuery(sql).executeUpdate();*/
		
		int size = this.getSession().doReturningWork(new ReturningWork<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				conn.setAutoCommit(false);//关闭自动提交
				Statement stmt = conn.createStatement();
				int ret = stmt.executeUpdate(sql);
//				conn.commit();//手动提交
				stmt.close();
//				if (null != conn) {
//					try {
//						conn.close();//  jdbc关闭连接  在jdbc未提交时,当conn.close()时,会默认先提交事务,再关闭连接.
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				return ret;
			}
		});
		return size;
	}

	/**
	 * 根据HQL语句,获得查询总记录数,例如:from...
	 */
	@Override
	public int getHQLCount(String hql, Object... parms) {
		int index = hql.toLowerCase().indexOf("from");
		int endIndex = hql.toLowerCase().indexOf("order by");
		String hqlCount ="select count(*) ";
		if (index != -1 && endIndex != -1) {
			hqlCount = hqlCount + hql.substring(index,endIndex);
		}else if(index != -1){
			hqlCount = hqlCount +  hql.substring(index);
		}else{
			throw new RuntimeException("无效的HQL查询语句[" + hql + "]");
		}
		Query<Long> query = this.getSession().createQuery(hqlCount,Long.class);
		for(int i=0;parms !=null && i< parms.length;i++)
		{
			query.setParameter(i, parms[i]);
		}
		return ((Long)query.getResultList().get(0)).intValue();
	}

	/**
	 * 根据原生sql语句，获得查询总记录数,例如:select count(*) from...
	 */
	@Override
	public int getSQLCount(String sql) {
		int  size = 0;
		ResultSet rs = this.getSession().doReturningWork(new ReturningWork<ResultSet>() {
			@Override
			public ResultSet execute(Connection conn) throws SQLException {
				PreparedStatement preparedStatement=conn.prepareStatement(sql);
                ResultSet resultSet=preparedStatement.executeQuery();
                preparedStatement.close();
                return resultSet;
			}
		});
		try {
			while(rs.next())
			{
				size = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			size = -1;
		}
		return size;
	}
}
