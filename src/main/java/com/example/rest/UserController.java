package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.entity.User;
import com.example.dao.mapper.UserMapper;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@PostMapping
	public Responser save(@RequestBody User user) {
		userMapper.insert(user);
		return Responser.builder().result("ok").build();
	}
	
	@RequestMapping
	@ResponseBody
	public Responser all() {
		return Responser.builder().result("ok").data(userMapper.selectList(null)).build();
	}
	
}
