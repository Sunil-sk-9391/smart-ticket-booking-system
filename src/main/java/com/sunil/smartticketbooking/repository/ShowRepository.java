package com.sunil.smartticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.smartticketbooking.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByMovieIdAndTheatreId(Long movieId, Long theatreId);

}