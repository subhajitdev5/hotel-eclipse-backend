package com.example.hotel.services;

import com.example.hotel.model.UserModel;
import com.example.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public UserModel updateUser(Integer id, UserModel userDetails) {
        UserModel user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public UserModel getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public boolean login(String email, String password) {
		UserModel user = userRepository.findByEmail(email);
		if (user==null) {
            return false;
        } 
		if(user.getPassword().equals(password))
		{
			return true;
		}
		else {
            return false;
        }
	}
}
