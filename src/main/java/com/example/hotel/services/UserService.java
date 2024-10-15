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
        // Check if user already exists by email to prevent duplicates
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }

        // Create a new UserModel to set firstName and lastName
        UserModel newUser = new UserModel();
        newUser.setFirstName(user.getFirstName()); // Expecting firstName
        newUser.setLastName(user.getLastName());   // Expecting lastName
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword()); // Consider hashing this password

        return userRepository.save(newUser);
    }

    public UserModel updateUser(Integer id, UserModel userDetails) {
        UserModel user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword()); // Consider hashing this password
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
        if (user == null) {
            return false; // User does not exist
        } 
        return user.getPassword().equals(password); // Check password
    }
}
