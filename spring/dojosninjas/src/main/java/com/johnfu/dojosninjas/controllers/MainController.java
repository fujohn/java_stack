package com.johnfu.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnfu.dojosninjas.models.Dojo;
import com.johnfu.dojosninjas.models.Ninja;
import com.johnfu.dojosninjas.services.DojoService;
import com.johnfu.dojosninjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String dojos(Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "dojolist.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	@PostMapping("/createdojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "dojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/createninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, 
			Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "ninja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String show(@PathVariable("dojoId") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "show.jsp";
	}
}	
