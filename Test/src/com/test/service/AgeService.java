/**
 * 
 */
package com.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.impl.AgeDaoImpl;
import com.test.model.Age;

/**
 * @author Safwan
 *
 */

@Service
@Transactional
public class AgeService {
	
	protected static Logger logger = Logger.getLogger("AgeService");
	 
	@Autowired
	private AgeDaoImpl ageDao;
 
	public List<Age> getAllAges() {		
		return ageDao.getAllAges();		
	}

}
