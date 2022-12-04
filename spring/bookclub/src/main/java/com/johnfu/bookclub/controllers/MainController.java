package com.johnfu.bookclub.controllers;

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

import com.johnfu.bookclub.models.Book;
import com.johnfu.bookclub.models.LoginUser;
import com.johnfu.bookclub.models.User;
import com.johnfu.bookclub.services.BookService;
import com.johnfu.bookclub.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model) {
	 
	    // Bind empty User and LoginUser objects to the JSP to capture the form input
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
	 
	    return "redirect:/books";
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
	 
	    return "redirect:/books";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);
	     
	    return "redirect:/";
	}
	
	@GetMapping("/books")
	public String books(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("books", bookServ.allBooks());
		
		return "book_list.jsp";
	}
	
	@GetMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("book", bookServ.findBook(id));
		return "book_info.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model) {
	    return "book_create.jsp";
	}
	
	@PostMapping("/createbook")
	public String createBook(@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "book_create.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			book.setUser(userServ.findById(userId));
			bookServ.createBook(book);
			return "redirect:/books/" + book.getId();
		}
	}
	
	@DeleteMapping("books/{bookId}/delete")
	public String deleteBook(@PathVariable("bookId") Long id) {
		bookServ.delete(id);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}/edit")
	public String updateBook(@PathVariable("bookId") Long id,
			@ModelAttribute("book") Book book,
			Model model) {
		model.addAttribute("book", bookServ.findBook(id));
	    return "book_edit.jsp";
	}
	
	@PutMapping("/editbook/{bookId}")
	public String editBook(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if (result.hasErrors()) {
			return "book_edit.jsp";
		} else {
			bookServ.update(book);
			return "redirect:/books/" + book.getId();
		}
	}
}
