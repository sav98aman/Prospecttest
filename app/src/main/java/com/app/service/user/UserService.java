package com.app.service.user;

import com.app.GlobalException.UserException;
import com.app.model.CurrentUserSession;
import com.app.model.User;
import com.app.model.UserDto;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public User finduser(String email) throws UserException;
	
	public CurrentUserSession Login(UserDto userdto)throws UserException;
	
}
