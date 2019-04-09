package com.first.crud.firstSpringCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.crud.firstSpringCrud.entitys.User;
import com.first.crud.firstSpringCrud.repository.UserRepository;

@Controller
@RequestMapping("/api")
public class RestController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "/add")
	public String addNewUser(@ModelAttribute("user") User user) {

		userRepository.save(user);
		return "redirect:../";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {

		return userRepository.findAll();
	}

	@PutMapping(value = "/update")
	public String editUser(@ModelAttribute("userUpdate") User userUpdate, Model model) {
		System.out.println("Userupdate:" + userUpdate.getId());
		System.out.println("UserUpdate" + userUpdate.getUsername());

		userRepository.save(userUpdate);
		model.addAttribute("title", "Form Inserir Usuário");

		return "redirect:../";
	}

	@DeleteMapping("/delete")
	public String deleteUser(@ModelAttribute("userDelete") User userDelete) {
		System.out.println("Delete");
		userRepository.delete(userDelete);
		return "redirect:../";
	}

}
