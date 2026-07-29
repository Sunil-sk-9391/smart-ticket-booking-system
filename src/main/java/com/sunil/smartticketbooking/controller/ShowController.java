package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Show;
import com.sunil.smartticketbooking.service.ShowService;

@RestController
@RequestMapping("/api/shows")
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@PostMapping("/add")
	public Show addShow(@RequestBody Show show) {
		return showService.addShow(show);
	}
	
	@GetMapping
	public List<Show>getAllShow(){
		return showService.getAllShow();
		
	}
	

}
