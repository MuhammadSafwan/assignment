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

import com.test.dao.OccupationDao;
import com.test.model.Occupation;

/**
 * @author Safwan
 *
 */

@Repository
@Transactional
public class OccupationDaoImpl implements OccupationDao{
	
	protected static Logger logger = Logger.getLogger("OccupationDao");

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Occupation> getAllOccupations() {
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		Query q = session.createQuery("FROM Occupation");
		List<Occupation> occupationList = q.list();
		return occupationList;
	}

}
