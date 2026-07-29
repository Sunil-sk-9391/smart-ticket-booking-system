package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Seat;
import com.sunil.smartticketbooking.service.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@PostMapping("/add")
	public Seat addSeat(@RequestBody Seat seat) {
		return seatService.addSeat(seat);
	}
	
	@GetMapping
	public List<Seat>getAllSeats(){
		return seatService.getAllSeats();
	}

}
