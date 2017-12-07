package com.pradeip.hibernate.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class BaseDao<T, P> {

	public final Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Constructor will find the the type of class being refered
	 */
	@SuppressWarnings("unchecked")
	public BaseDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Autowired
	public void save(T entity) {

		getSession().save(entity);

	};

	public void update(T entity) {
	};

	public void delete(T entity) {
	};

	public T findById(P pk) {
		return null;
	};

	public Session getSession() {

		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			
			System.out.println(session.toString());
			System.out.println("Found Session ----------------->");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

}
