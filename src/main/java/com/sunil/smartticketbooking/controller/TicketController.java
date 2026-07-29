package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.smartticketbooking.entity.Ticket;
import com.sunil.smartticketbooking.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/generate")
	public Ticket generateTicket(@RequestBody Ticket ticket) {
		return ticketService.generateTicket(ticket);
		
	}
	
	@GetMapping
	public List<Ticket>getAllTicket(){
		return ticketService.getAllTickets();
	}

}
