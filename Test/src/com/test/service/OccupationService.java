/**
 * 
 */
package com.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.impl.OccupationDaoImpl;
import com.test.model.Occupation;

/**
 * @author Safwan
 *
 */

@Service
@Transactional
public class OccupationService {
	
	protected static Logger logger = Logger.getLogger("OccupationService");
	 
	@Autowired
	private OccupationDaoImpl occupationDao;
 
	public List<Occupation> getAllOccupations() {		
		return occupationDao.getAllOccupations();		
	}

}
