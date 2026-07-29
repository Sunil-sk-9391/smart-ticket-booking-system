package com.sunil.smartticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Movie;
import com.sunil.smartticketbooking.repository.MovieRepository;


@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepository;


    public Movie addMovie(Movie movie){

        return movieRepository.save(movie);
    }


    public List<Movie> getMovies(){

        return movieRepository.findAll();
    }
}