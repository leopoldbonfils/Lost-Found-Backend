package com.Lost.FoundBackend.Lost.FoundBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.util.Optional;
import com.Lost.FoundBackend.Lost.FoundBackend.model.User;

import com.Lost.FoundBackend.Lost.FoundBackend.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // ✅ Save (Register) User
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        String response = userService.saveUser(user);

        if (response.equalsIgnoreCase("Email already exists") || response.equalsIgnoreCase("Phone number already exists")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    // ✅ Get All Users
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    // ✅ Search User by Email OR Phone
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchUser(@RequestParam(required = false) String email, @RequestParam(required = false) String phoneNumber) {
        Optional<User> userOptional = Optional.empty();

        if (email != null) {
            userOptional = userService.getUserByEmail(email);
        } else if (phoneNumber != null) {
            userOptional = userService.getUserByPhoneNumber(phoneNumber);
        } else {
            return new ResponseEntity<>("Please provide either email or phone number to search.", HttpStatus.BAD_REQUEST);
        }

        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    

    // ✅ Update User
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        String response = userService.updateUser(user);

        if (response.equalsIgnoreCase("User not found")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    // ✅ Delete User by ID
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        String response = userService.deleteUser(java.util.UUID.fromString(id));

        if (response.equalsIgnoreCase("User not found")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
