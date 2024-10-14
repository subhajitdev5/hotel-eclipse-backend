package com.example.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.model.Food;
import com.example.hotel.repository.Food_Re;

@Service
public class Food_Services {
	
	@Autowired
	private Food_Re foodrepo;
	
	public List<Food> getallFoods(){
		return foodrepo.findAll();		
	}
	
	public Food addFood(Food food) {
		return foodrepo.save(food);
	}
	
}
