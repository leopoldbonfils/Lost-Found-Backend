package com.Lost.FoundBackend.Lost.FoundBackend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.Lost.FoundBackend.Lost.FoundBackend.model.User;

import com.Lost.FoundBackend.Lost.FoundBackend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    
    public String saveUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            return "Email already exists";
        } else if(userRepository.existsByPhoneNumber(user.getPhoneNumber())){
            return "Phone number already exists";
        } else {
            userRepository.save(user);
            return "User saved successfully";
        }
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    
    public Optional<User> getUserById(UUID id){
        return userRepository.findById(id);
    }

    
    public List<User> searchByFirstName(String firstName){
        return userRepository.findByFirstNameContainingIgnoreCase(firstName);
    }


    public List<User> searchByLastName(String lastName){
        return userRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    // Update user
    public String updateUser(User user){
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
            return "User updated successfully";
        } else {
            return "User not found";
        }
    }

    // Delete user
    public String deleteUser(UUID id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }
}
