package com.sunil.smartticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Seat;
import com.sunil.smartticketbooking.repository.SeatRepository;

@Service
public class SeatService {
	@Autowired
	private SeatRepository seatRepository;
	
	public Seat addSeat(Seat seat) {
		return seatRepository.save(seat);
	}
	
	public List<Seat>getAllSeats(){
		return seatRepository.findAll();
	}

}
