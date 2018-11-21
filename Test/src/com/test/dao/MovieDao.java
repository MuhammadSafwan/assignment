/**
 * 
 */
package com.test.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.test.model.Movie;

/**
 * @author Safwan
 *
 */
@Transactional
public interface MovieDao {
	
	List<Movie> getAllMovies();
	
	List<Movie> getTop100();

	List<Movie> getTopWithAge(int age);

}
