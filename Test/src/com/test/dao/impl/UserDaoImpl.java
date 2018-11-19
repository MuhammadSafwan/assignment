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

import com.test.dao.UserDao;
import com.test.model.User;

/**
 * @author Safwan
 *
 */

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	protected static Logger logger = Logger.getLogger("UserDao");

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUsers() {
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		Query q = session.createQuery("FROM User");
		List<User> userList = q.list();
		return userList;
	}

}
