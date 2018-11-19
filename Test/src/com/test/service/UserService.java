/**
 * 
 */
package com.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.impl.UserDaoImpl;
import com.test.model.User;

/**
 * @author Safwan
 *
 */
@Service
@Transactional
public class UserService {
	
	protected static Logger logger = Logger.getLogger("UserService");
	 
	@Autowired
	private UserDaoImpl userDao;
 
	public List<User> getAllUsers() {		
		return userDao.getAllUsers();		
	}

}
