package com.devsuperior.jcprmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.jcprmovie.entities.Score;
import com.devsuperior.jcprmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
}
