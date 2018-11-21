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

import com.test.dao.MovieDao;
import com.test.model.Movie;

/**
 * @author Safwan
 *
 */

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

	protected static Logger logger = Logger.getLogger("MovieDao");

	@Autowired
	private SessionFactory sessionFactory;

	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getAllMovies() {

		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Query q = session.createQuery("FROM Movie");
		List<Movie> movieList = q.list();
		return movieList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getTop100() {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Query q = session.createQuery(
				"SELECT m.id, m.title, round(avg(r.rating),2) as rating, case when count(r.user_id)>100 then round(count(r.user_id),-2) else count(r.user_id) end as vote FROM Movie m join Rating r\r\n"
						+ "on m.id = r.movie_id\r\n" + "group by m.id \r\n" + "having count(r.user_id) > 20 \r\n"
						+ "order by rating desc");

		q.setFirstResult(0).setMaxResults(100);
		List<Movie> movieList = (List<Movie>) q.list();
		return movieList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getTopWithAge(int age) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Query q = session.createQuery(
				"SELECT m.id, m.title, round(avg(r.rating),2) as rating, case when count(r.user_id)>100 then round(count(r.user_id),-2) else count(r.user_id) end as votes\r\n" + 
				"from Movie m join Rating r on m.id = r.movie_id\r\n" + 
				"join User u on r.user_id = u.id\r\n" + 
				"join Age a on a.id = u.age_id\r\n" + 
				"where a.id =" + age +  "\r\n" + 
				"group by m.id\r\n" + 
				"order by rating desc");

		q.setFirstResult(0).setMaxResults(100);
		List<Movie> movieList = (List<Movie>) q.list();
		return movieList;
	}

}
