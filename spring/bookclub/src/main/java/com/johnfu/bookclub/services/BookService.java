package com.johnfu.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnfu.bookclub.models.Book;
import com.johnfu.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optional = bookRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public Book update(Book b) {
		return bookRepo.save(b);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
