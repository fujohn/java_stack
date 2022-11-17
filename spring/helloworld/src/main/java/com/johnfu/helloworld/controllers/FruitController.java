package com.johnfu.helloworld.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FruitController {
	
	@RequestMapping("/")
    public String index(HttpSession session, Model model) {
		model.addAttribute("fruit", "banana");
        session.setAttribute("name", "Karissa");
        
		return "demo.jsp";
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpSession session, Model model) {
		String userName = (String) session.getAttribute("name");
		System.out.println("The name is " + userName);
		
		Integer currentCount;
		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
				session.setAttribute("count", 0);
				currentCount = (Integer) session.getAttribute("count");
			}
			else {
			// increment the count by 1 using getAttribute and setAttribute
				Integer formerCount = (Integer) session.getAttribute("count");
				session.setAttribute("count", formerCount + 1);
				currentCount = (Integer) session.getAttribute("count");
			}
		model.addAttribute("countToShow", currentCount);
		return "welcome.jsp";
	}
	
	

    @RequestMapping("/dojos")
    public String dojo(Model model) {
        ArrayList<String> dojos = new ArrayList<String>();
        dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
        return "index.jsp";
    }
    
    //Forms
    @RequestMapping("/form")
	public String index() {
		return "form.jsp";
	}
    
    @PostMapping("/login") //POST request, should redirect (see next mapping)
    public String login(@RequestParam(value="email") String email, 
    		@RequestParam(value="password") String password, 
    		HttpSession session,
    		RedirectAttributes redirectAttributes) {
        
    		if (password.length() < 5) {
    			redirectAttributes.addFlashAttribute("error", "Password must be at least 5 characters long.");
    			return "redirect:/form";
    		} else {
    			session.setAttribute("email", email);
            	return "redirect:/home"; // <-- we'll change this when we learn redirecting
    		}
        	// CODE TO PROCESS FORM ie. check email and password
        	
    }
    
    @RequestMapping("/home")
    public String home() {
    	return "results.jsp";
    }
}

