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
import com.example.hotel.services.Food_Services;


@RestController

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/foods")
public class FoodController {
	@Autowired
	private Food_Services foodservices;
	
	@GetMapping
	public List<Food> getAllFoods() {
		return foodservices.getallFoods();
	}
	
	@PostMapping
	public Food addFood(@RequestBody Food food) {
		return foodservices.addFood(food);
	}


}
