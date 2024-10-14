package com.example.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.Room;
import com.example.hotel.service.BookingService;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/rooms")
public class BookingController {
	@Autowired
	
	private BookingService bookingService;
	
	@GetMapping
	public List<Room> getAllBookings(){
		return bookingService.getAllBookings();
	}
	
	
	@PostMapping
	public Room createBooking(@RequestBody Room room) {
		return bookingService.saveBooking(room);
	}
	
	@GetMapping("/{id}")
	public Room getBookingById(@PathVariable Long id) {
		return bookingService.getRoomById(id);
	}
}
