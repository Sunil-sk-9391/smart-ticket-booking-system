package com.sunil.smartticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.smartticketbooking.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}