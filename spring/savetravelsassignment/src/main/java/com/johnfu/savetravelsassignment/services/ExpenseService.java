package com.johnfu.savetravelsassignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnfu.savetravelsassignment.models.Expense;
import com.johnfu.savetravelsassignment.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository repo;

	public ExpenseService(ExpenseRepository repo) {
		this.repo = repo;
	}
	
	// returns all expenses
	public List<Expense> allExpenses() {
		return repo.findAll();
	}
	
	// creates an expense
	public Expense createExpense(Expense e) {
		return repo.save(e);
	}
	
	// finds one expense
	public Expense find(Long id) {
		Optional<Expense> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public Expense update(Expense e) {
		return repo.save(e);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
