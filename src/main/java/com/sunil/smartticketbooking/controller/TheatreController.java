package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Theatre;
import com.sunil.smartticketbooking.service.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;
	
	
	@PostMapping("/add")
	public Theatre addTheatre(@RequestBody Theatre theatre)
	{
		return theatreService.addTheatre(theatre);
	}
	
	
	@GetMapping
	public List<Theatre>getAllTheatres(){
		return theatreService.getAllTheatres();
	}
	
	@GetMapping("/count")
	public long getTheatreCount() {

	    return theatreService.getTheatreCount();

	}
	@GetMapping("/{id}")
	public Theatre getTheatreById(@PathVariable Long id) {
	    return theatreService.getTheatreById(id);
	}

}
