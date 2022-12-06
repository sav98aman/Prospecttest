package com.app.service.user;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.GlobalException.UserException;
import com.app.dao.CurrentUserSeesionDao;
import com.app.dao.UserDao;
import com.app.model.CurrentUserSession;
import com.app.model.User;
import com.app.model.UserDto;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private CurrentUserSeesionDao curruserDao;
	
	
	@Override
	public User registerUser(User user) throws UserException {
		
		User registerUser=userdao.findByEmail(user.getEmail());
		if (registerUser != null) {
			throw new UserException("USer Is All reday register With this email id "+user.getEmail());
		}
		return userdao.save(user);
	}
	@Override
	public User finduser(String email) throws UserException {
		User registerUser=userdao.findByEmail(email);
		if (registerUser == null) {
			throw new UserException("USer Is Not register With this Email " +email);
		}
		return registerUser;
	}
	@Override
	public CurrentUserSession Login(UserDto userdto) throws UserException {
		User user =finduser(userdto.getEmail());
		
		
		Optional<CurrentUserSession> optcuurentUser=curruserDao.findById(user.getUser_id());
		if(optcuurentUser.isPresent()) {
			throw new UserException(" User Is All reday Login");
		}
	
		if(!user.getPassword().equals(userdto.getPassword())) {
			throw new UserException(" password Is Worng");
		}
		CurrentUserSession currentUserSeesion=new CurrentUserSession();
		String key= RandomString.make(6);
		currentUserSeesion.setIslogin(true);
		currentUserSeesion.setTimestamp(LocalDateTime.now());
		currentUserSeesion.setUser_id(user.getUser_id());
		currentUserSeesion.setUuid(key);
		
		return curruserDao.save(currentUserSeesion);
		
	}

}
