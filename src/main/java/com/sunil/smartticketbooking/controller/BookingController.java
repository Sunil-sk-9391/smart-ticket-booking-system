package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Booking;
import com.sunil.smartticketbooking.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/book")
	public Booking bookTicket(@RequestBody Booking booking) {
		return bookingService.bookTicket(booking);
	}
	
	@GetMapping
	public List<Booking>getAllBooking(){
		return bookingService.getAllBookings();
	}
	
	

}
