package com.sunil.smartticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.smartticketbooking.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
