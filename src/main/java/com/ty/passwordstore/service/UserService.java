package com.ty.passwordstore.service;

import com.ty.passwordstore.dao.UserDao;
import com.ty.passwordstore.dto.User;

public class UserService {

	public User saveUser(User user) {
		return new UserDao().saveUser(user);
	}
	
	public boolean validateUser(String email, String password) {
		return new UserDao().validateUser(email,password);
	}
}