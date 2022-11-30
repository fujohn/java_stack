package com.johnfu.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.johnfu.relationships.models.Person;

public interface RelationshipRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
}
