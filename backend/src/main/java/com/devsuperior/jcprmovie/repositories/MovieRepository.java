package com.devsuperior.jcprmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.jcprmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
}
