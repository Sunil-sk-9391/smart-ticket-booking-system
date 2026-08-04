package com.sunil.smartticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.smartticketbooking.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByShowId(Long showId);

    long countByBooked(boolean booked);

}