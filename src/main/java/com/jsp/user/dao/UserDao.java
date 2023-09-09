package com.jsp.user.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.user.dto.User;
import com.jsp.user.repository.UserRepo;
import com.jsp.user.util.ResponseStructure;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
       return repo.save(user);
	}

	public User updateUser(int id, User user) {
		Optional<User> optional=repo.findById(id);
		  if(optional.isPresent()) {
//			  it is having a user
			  user.setId(id);
			 return  repo.save(user);
		  }
		  return null;
		  
	}

	public User findUserById(int id) {
		Optional<User> optional=repo.findById(id);
        if(optional.isPresent()) {
        	User user=optional.get();
        	return user;
        }return null;
	}

	public User deleteUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}

	public List<User> findAllUser() {
		List<User> list=repo.findAll();
		return list;
	}

	public List<User> deleteAllUser() {
		List<User> list=repo.findAll();
		if(list.isEmpty()) {
		return null;
		}else {
			repo.deleteAll();
			return list;
		}
	}
}
