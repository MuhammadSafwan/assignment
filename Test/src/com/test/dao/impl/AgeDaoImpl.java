/**
 * 
 */
package com.test.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.AgeDao;
import com.test.model.Age;

/**
 * @author Safwan
 *
 */

@Repository
@Transactional
public class AgeDaoImpl implements AgeDao{
	
	protected static Logger logger = Logger.getLogger("AgeDao");

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Age> getAllAges() {
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		Query q = session.createQuery("FROM Age");
		List<Age> ageList = q.list();
		return ageList;
	}

}
