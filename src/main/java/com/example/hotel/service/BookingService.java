package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;

@Service
public class BookingService {
	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room>getAllBookings() {
		return roomRepository.findAll();
	}
	
	public Room saveBooking(Room room) {
		return roomRepository.save(room);
	}
	public Room getRoomById(Long Id) {
		//room.setAvailable(false);
		return roomRepository.findById(Id).orElse(null);
	}
}
