package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Seat;
import com.sunil.smartticketbooking.service.SeatService;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin("*")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // Add Seat
    @PostMapping("/add")
    public Seat addSeat(@RequestBody Seat seat) {

        return seatService.addSeat(seat);

    }

    // Get Seats By Show
    @GetMapping("/show/{showId}")
    public List<Seat> getSeatsByShow(@PathVariable Long showId) {

        return seatService.getSeatsByShow(showId);

    }

    // Available Seats Count
    @GetMapping("/available/count")
    public long getAvailableSeatCount() {

        return seatService.getAvailableSeatCount();

    }

    // Booked Seats Count
    @GetMapping("/booked/count")
    public long getBookedSeatCount() {

        return seatService.getBookedSeatCount();

    }

}