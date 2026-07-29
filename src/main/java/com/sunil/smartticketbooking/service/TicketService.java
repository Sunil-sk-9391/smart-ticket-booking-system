package com.sunil.smartticketbooking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Booking;
import com.sunil.smartticketbooking.entity.Ticket;
import com.sunil.smartticketbooking.repository.BookingRepository;
import com.sunil.smartticketbooking.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Ticket generateTicket(Ticket ticket) {

        Booking booking = bookingRepository.findById(ticket.getBooking().getId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        ticket.setBooking(booking);
        ticket.setIssuedAt(LocalDateTime.now());
        ticket.setTicketNumber(UUID.randomUUID().toString());

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}