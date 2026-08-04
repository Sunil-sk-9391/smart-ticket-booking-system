package com.sunil.smartticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Booking;
import com.sunil.smartticketbooking.entity.Seat;
import com.sunil.smartticketbooking.repository.BookingRepository;
import com.sunil.smartticketbooking.repository.SeatRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SeatRepository seatRepository;

    
    public Booking bookTicket(Booking booking) {

        Seat seat = seatRepository.findById(
                booking.getSeat().getId())
                .orElseThrow(() ->
                        new RuntimeException("Seat not found"));

        if (seat.isBooked()) {

            throw new RuntimeException("Seat already booked");

        }

        seat.setBooked(true);

        seatRepository.save(seat);

        booking.setSeat(seat);

        return bookingRepository.save(booking);

    }

    
    public List<Booking> getBookingsByUser(Long userId) {

        return bookingRepository.findByUserId(userId);

    }

   
    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();

    }

    
    public long getBookingCount() {

        return bookingRepository.count();

    }

    
    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);

    }

    
   

    public Booking cancelBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new RuntimeException("Booking Not Found"));

        Seat seat = booking.getSeat();

       
        seat.setBooked(false);

        seatRepository.save(seat);

        
        booking.setBookingStatus("CANCELLED");

        return bookingRepository.save(booking);

    }

}