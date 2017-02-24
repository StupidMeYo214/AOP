package com.bjsx.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bjsx.dao.UserDAO;
import com.bjsx.dao.impl.UserDAOImpl1;
import com.bjsx.spring.User;

@Component("service")
@Scope("prototype")
public class UserService {

	private UserDAO userDAO ;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name="dao2")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void add(User u){
		this.userDAO.save(u);
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("destroyed");
	}
	
}
