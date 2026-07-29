package com.sunil.smartticketbooking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.entity.Booking;
import com.sunil.smartticketbooking.entity.Payment;
import com.sunil.smartticketbooking.repository.BookingRepository;
import com.sunil.smartticketbooking.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	 public Payment makePayment(Payment payment) {

	        Booking booking = bookingRepository.findById(payment.getBooking().getId())
	                .orElseThrow(() -> new RuntimeException("Booking not found"));

	        payment.setBooking(booking);
	        payment.setPaymentTime(LocalDateTime.now());
	        payment.setPaymentStatus("SUCCESS");

	        return paymentRepository.save(payment);
	    }
	 
	 public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }

}
