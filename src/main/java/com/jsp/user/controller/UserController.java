package com.jsp.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.user.dao.UserDao;
import com.jsp.user.dto.User;
import com.jsp.user.service.UserService;
import com.jsp.user.util.ResponseStructure;

@RestController
public class UserController {
   @Autowired
   private UserService service;

	
    @PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
    @PutMapping("/update")
	public ResponseStructure<User> updateUser(@RequestParam int id,@RequestBody User user ) {
		return service.updateUser(id,user);
	}
//    @GetMapping("/find")
//    public User findUserById(@RequestParam int id) {
//    	return dao.findUserById(id);
//    }
//    @DeleteMapping("/delete")
//    public User deleteUserById(@RequestParam int id) {
//    	return dao.deleteUserById(id);
//    }
//    @GetMapping("/findall")
//    public List<User> findAllUser(){
//    	return dao.findAllUser();
//    }
//    @DeleteMapping("/deleteall")
//    public List<User> deleteAllUser(){
//    	return dao.deleteAllUser();
//    }
}
