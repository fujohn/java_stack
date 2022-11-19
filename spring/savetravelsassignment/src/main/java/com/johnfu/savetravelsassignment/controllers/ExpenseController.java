package com.johnfu.savetravelsassignment.controllers;

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

import com.johnfu.savetravelsassignment.models.Expense;
import com.johnfu.savetravelsassignment.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenses;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		
		model.addAttribute("expenses", expenses.allExpenses());
		
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenses.allExpenses());
			return "index.jsp";
		}
		System.out.println("this is the platform solution.");
		expenses.createExpense(expense);
		
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenses.find(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			Expense expenseUnchanged = expenses.find(id);
			model.addAttribute("expense", expenseUnchanged);
			return "edit.jsp";
		} else {
			expenses.update(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Expense expense = expenses.find(id);
		model.addAttribute("expense", expense);
		return "view.jsp";
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenses.delete(id);
		return "redirect:/expenses";
	}
}
