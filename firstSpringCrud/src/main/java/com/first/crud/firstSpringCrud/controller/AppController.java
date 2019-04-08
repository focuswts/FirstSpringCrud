package com.first.crud.firstSpringCrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Titulo Crud");
		return "index";

	}

}
