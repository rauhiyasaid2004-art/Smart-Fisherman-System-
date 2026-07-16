package com.smartfisherman.smartfishermansystem.controller;


import com.smartfisherman.smartfishermansystem.model.User;
import com.smartfisherman.smartfishermansystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {


    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public Object login(@RequestBody User loginUser){

        Optional<User> user =
                userRepository.findByEmail(loginUser.getEmail());


        if(user.isPresent()){

            User existingUser = user.get();


            if(existingUser.getPassword()
                    .equals(loginUser.getPassword())){

                return existingUser;

            }

        }


        return "Invalid Email or Password";

    }

}
