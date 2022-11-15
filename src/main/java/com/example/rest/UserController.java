package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.User;
import com.example.dao.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("save")
	@ResponseBody
	public Responser save(@RequestParam String name, @RequestParam String email) {
		return Responser.builder().result("ok").data(
				userRepository.save(User.builder().name(name).email(email).build())).build();
	}
	
	@GetMapping("all")
	@ResponseBody
	public Responser all() {
		return Responser.builder().result("ok").data(
				userRepository.findAll()).build();
	}
	
}
