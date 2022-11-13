package com.johnfu.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@GetMapping("/") // default page redirect
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String omikuji() {
		return "form.jsp";
	}
	
	@PostMapping("/omikuji/createomikuji")
	public String create(@RequestParam(value="number") int number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="endeavor") String endeavor,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="message") String message,
    		HttpSession session) {
		String omikuji = String.format("In %s years, you will live in %s with %s as your roommate, %s for a living. The next time you see a %s, you will have good luck. Also, %s.",
				number, city, person, endeavor, livingThing, message);
		session.setAttribute("omikuji", omikuji);
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		String omikujiMessage = (String) session.getAttribute("okimuji");
		model.addAttribute("omikuji", omikujiMessage);
		return "omikuji.jsp";
	}
}
