package com.johnfu.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnfu.beltexam.models.Game;
import com.johnfu.beltexam.repositories.GameRepository;


@Service
public class GameService {

	@Autowired
	GameRepository gameRepo;
	
	public List<Game> allGames() {
		return gameRepo.findAll();
	}
	
	public Game createGame(Game b) {
		return gameRepo.save(b);
	}
	
	public Game findGame(Long id) {
		Optional<Game> optional = gameRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public Game update(Game b) {
		return gameRepo.save(b);
	}
	
	public void delete(Long id) {
		gameRepo.deleteById(id);
	}
}
