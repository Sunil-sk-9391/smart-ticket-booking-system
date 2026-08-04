package com.sunil.smartticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sunil.smartticketbooking.entity.Theatre;
import com.sunil.smartticketbooking.repository.TheatreRepository;

@Service
public class TheatreService {
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	public Theatre addTheatre(Theatre theatre) {
		return theatreRepository.save(theatre);
	}
	
	public List<Theatre>getAllTheatres(){
		return theatreRepository.findAll();
		
	}
	
	public long getTheatreCount() {

	    return theatreRepository.count();

	}
	
	public Theatre getTheatreById(Long id) {

	    return theatreRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Theatre Not Found"));

	}

}
