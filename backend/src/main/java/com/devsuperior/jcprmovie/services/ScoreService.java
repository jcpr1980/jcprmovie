package com.devsuperior.jcprmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.jcprmovie.dto.MovieDTO;
import com.devsuperior.jcprmovie.dto.ScoreDTO;
import com.devsuperior.jcprmovie.entities.Movie;
import com.devsuperior.jcprmovie.entities.Score;
import com.devsuperior.jcprmovie.entities.User;
import com.devsuperior.jcprmovie.repositories.MovieRepository;
import com.devsuperior.jcprmovie.repositories.ScoreRepository;
import com.devsuperior.jcprmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
	
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		//Calculo da Média
		
		double sum = 0.0;
		for (Score s : movie.getListScores()) {
			sum = sum + s.getValue();			
		}
		double avgScores = sum /movie.getListScores().size();
		
		movie.setScore(avgScores);
		movie.setCount(movie.getListScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
		
	}

		
	}


