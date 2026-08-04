package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Booking;
import com.sunil.smartticketbooking.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Book Ticket
    @PostMapping
    public Booking bookTicket(@RequestBody Booking booking) {

        return bookingService.bookTicket(booking);

    }

    // User Bookings
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {

        return bookingService.getBookingsByUser(userId);

    }

    // Admin - All Bookings
    @GetMapping("/all")
    public List<Booking> getAllBookings() {

        return bookingService.getAllBookings();

    }

    // Dashboard Count
    @GetMapping("/count")
    public long getBookingCount() {

        return bookingService.getBookingCount();

    }

    // Cancel Booking
    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {

        return bookingService.cancelBooking(bookingId);

    }

    // Delete Booking
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {

        bookingService.deleteBooking(id);

        return "Booking Deleted Successfully";

    }

}