package com.sunil.smartticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Seat;
import com.sunil.smartticketbooking.entity.Show;
import com.sunil.smartticketbooking.repository.SeatRepository;
import com.sunil.smartticketbooking.repository.ShowRepository;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    public Show addShow(Show show) {

        System.out.println("========== ADD SHOW METHOD CALLED ==========");

        Show savedShow = showRepository.save(show);

        System.out.println("Saved Show ID : " + savedShow.getId());

        char[] rows = {'A','B','C','D','E','F'};

        for(char row : rows){

            for(int i=1;i<=10;i++){

                Seat seat = new Seat();

                seat.setShow(savedShow);
                seat.setSeatNumber(row + String.valueOf(i));
                seat.setSeatType("REGULAR");
                seat.setBooked(false);

                seatRepository.save(seat);

            }
        }

        System.out.println("========== 60 SEATS CREATED ==========");

        return savedShow;
    }

    public List<Show> getAllShow() {

        return showRepository.findAll();

    }

    public List<Show> getShowsByMovieAndTheatre(
            Long movieId,
            Long theatreId) {

        return showRepository.findByMovieIdAndTheatreId(
                movieId,
                theatreId);

    }

    public Show getShowById(Long id) {

        return showRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Show Not Found"));

    }

    public Show updateShow(Long id, Show show) {

        Show existingShow = showRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Show Not Found"));

        existingShow.setMovie(show.getMovie());
        existingShow.setTheatre(show.getTheatre());
        existingShow.setShowDate(show.getShowDate());
        existingShow.setShowTime(show.getShowTime());
        existingShow.setTicketPrice(show.getTicketPrice());

        return showRepository.save(existingShow);

    }

    public void deleteShow(Long id) {

        showRepository.deleteById(id);

    }

    public long getShowCount() {

        return showRepository.count();

    }
    
    

}