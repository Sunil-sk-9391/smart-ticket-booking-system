package com.sunil.smartticketbooking.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Movie;
import com.sunil.smartticketbooking.service.MovieService;


@RestController
@RequestMapping("/api/movies")
public class MovieController {


    @Autowired
    private MovieService movieService;


    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie){

        return movieService.addMovie(movie);
    }



    @GetMapping
    public List<Movie> getMovies(){

        return movieService.getMovies();
    }
}