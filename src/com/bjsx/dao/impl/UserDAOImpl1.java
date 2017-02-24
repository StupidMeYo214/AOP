package com.bjsx.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.bjsx.dao.UserDAO;
import com.bjsx.spring.User;


public class UserDAOImpl1 implements UserDAO {

	
	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		System.out.println("user saved");
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		System.out.println("deleted");
	}

}
