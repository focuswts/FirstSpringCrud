package com.first.crud.firstSpringCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.crud.firstSpringCrud.entitys.User;
import com.first.crud.firstSpringCrud.repository.UserRepository;

@Controller
@RequestMapping("/api")
public class RestController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String password,
			@RequestParam String email) {

		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setEmail(email);

		userRepository.save(user);
		return "Saved";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {

		return userRepository.findAll();
	}

}
