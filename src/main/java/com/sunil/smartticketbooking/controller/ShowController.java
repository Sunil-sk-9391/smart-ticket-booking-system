package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.entity.Show;
import com.sunil.smartticketbooking.service.ShowService;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin("*")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/add")
    public Show addShow(@RequestBody Show show) {

        return showService.addShow(show);

    }

    @GetMapping
    public List<Show> getAllShow() {

        return showService.getAllShow();

    }

    @GetMapping("/movie/{movieId}/theatre/{theatreId}")
    public List<Show> getShowsByMovieAndTheatre(
            @PathVariable Long movieId,
            @PathVariable Long theatreId) {

        return showService.getShowsByMovieAndTheatre(movieId, theatreId);

    }

    @GetMapping("/{id}")
    public Show getShowById(@PathVariable Long id) {

        return showService.getShowById(id);

    }

    @PutMapping("/{id}")
    public Show updateShow(
            @PathVariable Long id,
            @RequestBody Show show) {

        return showService.updateShow(id, show);

    }

    @DeleteMapping("/{id}")
    public String deleteShow(@PathVariable Long id) {

        showService.deleteShow(id);

        return "Show Deleted Successfully";

    }

    @GetMapping("/count")
    public long getShowCount() {

        return showService.getShowCount();

    }

}