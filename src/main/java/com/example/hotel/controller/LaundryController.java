package com.example.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.Food;
import com.example.hotel.model.Laundry;
import com.example.hotel.services.Food_Services;
import com.example.hotel.services.Laundry_Services;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/laundry")
public class LaundryController {
	@Autowired
	private Laundry_Services laundryservices;
	
	@GetMapping
	public List<Laundry> getAllLaundry() {
		return laundryservices.getallLaundry();
	}
	
	@PostMapping
	public Laundry addLaundry(@RequestBody Laundry laundry ) {
		return laundryservices.addLaundry(laundry);
	}


}