package com.johnfu.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnfu.mvc.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// declare then function to query
	// this method retrieves all the books from the database (select * from Book)
    List<Book> findAll();
    // this method finds books with descriptions containing the search string (where description like)
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string (count from Book where)
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title (delete)
    Long deleteByTitleStartingWith(String search);
}
