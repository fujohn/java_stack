package com.johnfu.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnfu.dojosninjas.models.Dojo;
import com.johnfu.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepo;
	
	//	get all dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	// create a dojo
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// find a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optional = dojoRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
}
