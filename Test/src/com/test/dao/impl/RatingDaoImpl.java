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

import com.test.dao.RatingDao;
import com.test.model.Rating;

/**
 * @author Safwan
 *
 */

@Repository
@Transactional
public class RatingDaoImpl implements RatingDao{
	
	protected static Logger logger = Logger.getLogger("RatingDao");

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getAllRatings() {
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		Query q = session.createQuery("FROM Rating");
		List<Rating> ratingList = q.list();
		return ratingList;
	}

}
