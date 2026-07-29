package com.sunil.smartticketbooking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private  User user;
	
	@ManyToOne
	@JoinColumn(name="show_id")
	private Show show;
	
	@ManyToOne
	@JoinColumn(name="seat_id")
	private Seat seat;
	
	private LocalDateTime bookingTime;
	
	private String bookingStatus;
	
	public Booking() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	

}
