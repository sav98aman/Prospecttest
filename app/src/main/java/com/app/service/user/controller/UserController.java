package com.app.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.GlobalException.UserException;
import com.app.model.CurrentUserSession;
import com.app.model.User;
import com.app.model.UserDto;
import com.app.service.user.UserServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userserviceimpl;
	
	@PostMapping(value = "/register")
	public ResponseEntity<User> register_New_User_Handaller(@RequestBody User user) throws UserException{
		return new ResponseEntity<User>(userserviceimpl.registerUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{email}")
	public ResponseEntity<User> register_New_User_Handaller(@PathVariable String email) throws UserException{
		return new ResponseEntity<User>(userserviceimpl.finduser(email),HttpStatus.OK);
	}
	
	@GetMapping(value = "/login}")
	public ResponseEntity<CurrentUserSession> login_New_User_Handaller(@RequestBody UserDto userdto) throws UserException{
		
		return new ResponseEntity<CurrentUserSession>(userserviceimpl.Login(userdto),HttpStatus.OK);
	}
}
