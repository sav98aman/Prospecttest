package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public interface UserDao extends JpaRepository<User	, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.Email=?1")
	public User findByEmail(String email);
}
