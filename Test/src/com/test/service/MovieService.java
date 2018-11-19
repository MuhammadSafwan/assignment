/**
 * 
 */
package com.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.impl.MovieDaoImpl;
import com.test.model.Movie;

/**
 * @author Safwan
 *
 */

@Service
@Transactional
public class MovieService {
	
	protected static Logger logger = Logger.getLogger("MovieService");
	 
	@Autowired
	private MovieDaoImpl movieDao;
 
	public List<Movie> getAllMovies() {		
		return movieDao.getAllMovies();		
	}
	
	public List<Movie> getTop100() {		
		return movieDao.getTop100();		
	}

}
