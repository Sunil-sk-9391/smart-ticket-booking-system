package com.sunil.smartticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Show;
import com.sunil.smartticketbooking.repository.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepository;
	
	
	public Show addShow(Show show) {
		return showRepository.save(show);
	}
	
	
	public List<Show>getAllShow(){
		return showRepository.findAll();
	}
	

}
