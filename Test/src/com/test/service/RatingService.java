/**
 * 
 */
package com.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.impl.RatingDaoImpl;
import com.test.model.Rating;

/**
 * @author Safwan
 *
 */

@Service
@Transactional
public class RatingService {
	
	protected static Logger logger = Logger.getLogger("RatingService");
	 
	@Autowired
	private RatingDaoImpl ratingDao;
 
	public List<Rating> getAllRatings() {		
		return ratingDao.getAllRatings();		
	}

}
