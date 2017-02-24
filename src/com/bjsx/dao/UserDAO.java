package com.bjsx.dao;

import com.bjsx.spring.User;

public interface UserDAO {
	
	public void save(User u);
	public void delete(User u);
}
