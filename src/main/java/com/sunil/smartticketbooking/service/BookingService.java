package com.sunil.smartticketbooking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Booking;
import com.sunil.smartticketbooking.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookTicket(Booking booking) {

        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingStatus("BOOKED");

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}