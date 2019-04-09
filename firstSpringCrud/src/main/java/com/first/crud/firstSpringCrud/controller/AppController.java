package com.first.crud.firstSpringCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.first.crud.firstSpringCrud.entitys.User;
import com.first.crud.firstSpringCrud.repository.UserRepository;

@Controller
public class AppController {

	private final UserRepository userService;

	@Autowired
	public AppController(UserRepository userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		List<User> usuarios = (List<User>) userService.findAll();
		model.addAttribute("title", "Form Inserir Usuário");
		model.addAttribute("user", new User());
		model.addAttribute("users", usuarios);
		model.addAttribute("userUpdate", new User());
		return "index";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("userUpdate") User userUpdate, Model model) {
//		System.out.println("User: " + userUpdate.getId());
//		System.out.println("Username: " + userUpdate.getUsername());
//		System.out.println("Email: " + userUpdate.getEmail());
		model.addAttribute("title", "Form Atualizar Usuário");
		model.addAttribute("userUpdate", userUpdate);
		return "indexUpdate";

	}
	
	

}
