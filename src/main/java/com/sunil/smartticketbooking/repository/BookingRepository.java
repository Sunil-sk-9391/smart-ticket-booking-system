package com.sunil.smartticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.smartticketbooking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long>{

}
