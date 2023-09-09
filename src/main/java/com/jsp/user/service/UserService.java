package com.jsp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.user.dao.UserDao;
import com.jsp.user.dto.User;
import com.jsp.user.exception.UserIdNOtFoundException;
import com.jsp.user.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
	User dbUser=dao.saveUser(user);
	ResponseStructure<User> structure=new ResponseStructure<User>();
	structure.setMessage("User data saved successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(dbUser);
	return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	public ResponseStructure<User> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id, user);
	if(dbUser!=null) {
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("User data updated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dbUser);
		return structure;
	}else {
//		raise my id not found exception
		throw new UserIdNOtFoundException("Sorry failed to update User");
	}
	}

	
	
}
