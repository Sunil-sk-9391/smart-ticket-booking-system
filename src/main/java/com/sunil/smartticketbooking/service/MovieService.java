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

    public Movie addMovie(Movie movie) {

        return movieRepository.save(movie);

    }

    public List<Movie> getMovies() {

        return movieRepository.findAll();

    }

    public Movie getMovieById(Long id) {

        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie Not Found"));

    }

    public Movie updateMovie(Long id, Movie movie) {

        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie Not Found"));

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setPoster(movie.getPoster());

        return movieRepository.save(existingMovie);

    }

    public void deleteMovie(Long id) {

        movieRepository.deleteById(id);

    }
    
    public long getMovieCount() {

        return movieRepository.count();

    }

}