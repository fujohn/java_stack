package com.johnfu.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.johnfu.beltexam.models.Game;
import com.johnfu.beltexam.models.LoginUser;
import com.johnfu.beltexam.models.User;
import com.johnfu.beltexam.services.GameService;
import com.johnfu.beltexam.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private GameService gameServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
	    return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, 
			Model model, 
			HttpSession session) {
	     
		User user = userServ.register(newUser, result);
		
	    if(result.hasErrors()) {
	        // Be sure to send in the empty LoginUser before re-rendering the page.
	        model.addAttribute("newLogin", new LoginUser());
	        return "login.jsp";
	    }
	    
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, 
			Model model, 
			HttpSession session) {
	     
		User user = userServ.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "login.jsp";
	    }
	     
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);
	     
	    return "redirect:/";
	}
	
	@GetMapping("/home")
	public String books(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("games", gameServ.allGames());
		
		return "game_list.jsp";
	}
	
	@GetMapping("/games/{gameId}")
	public String showGame(@PathVariable("gameId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("game", gameServ.findGame(id));
		return "game_info.jsp";
	}
	
	@GetMapping("/games/new")
	public String newBook(@ModelAttribute("game") Game game, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
	    return "game_new.jsp";
	}
	
	@PostMapping("/creategame")
	public String createGame(@Valid @ModelAttribute("game") Game game,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "game_new.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			game.setUser(userServ.findById(userId));
			gameServ.createGame(game);
			return "redirect:/home";
		}
	}
	
	@DeleteMapping("games/{gameId}/delete")
	public String deleteGame(@PathVariable("gameId") Long id) {
		gameServ.delete(id);
		return "redirect:/home";
	}
	
	@GetMapping("/games/{gameId}/edit")
	public String updateGame(@PathVariable("gameId") Long id,
			@ModelAttribute("game") Game game,
			Model model,
			HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Game currGame = gameServ.findGame(id);
		System.out.println(session.getAttribute("userId"));
		System.out.println(currGame.getUser().getId());
		if ((long) session.getAttribute("userId") == currGame.getUser().getId()) { // Adding this to prevent cross editing
			model.addAttribute("game", currGame);
		    return "game_edit.jsp";
		} else {
			return "redirect:/home";
		}
		
	}
	
	@PutMapping("/editgame/{id}")
	public String editGame(@PathVariable("id") Long id,
			Model model,
			@Valid @ModelAttribute("game") Game game,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("game", gameServ.findGame(id));
			return "game_edit.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			game.setUser(userServ.findById(userId));
			gameServ.update(game);
			return "redirect:/home";
		}
	}
}
