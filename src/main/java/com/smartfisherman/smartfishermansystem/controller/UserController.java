package com.smartfisherman.smartfishermansystem.controller;

import com.smartfisherman.smartfishermansystem.model.User;
import com.smartfisherman.smartfishermansystem.security.JwtService;
import com.smartfisherman.smartfishermansystem.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {


    private final UserService userService;
    private final JwtService jwtService;


    public UserController(UserService userService,
                          JwtService jwtService){

        this.userService = userService;
        this.jwtService = jwtService;

    }



    // REGISTER

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){

        return userService.saveUser(user);

    }





    // LOGIN WITH JWT TOKEN

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody User loginUser){


        Optional<User> user =
                userService.getUserByEmail(loginUser.getEmail());


        Map<String,String> response = new HashMap<>();


        if(user.isPresent() &&
                user.get().getPassword()
                .equals(loginUser.getPassword())){


            String token =
                    jwtService.generateToken(
                            loginUser.getEmail()
                    );


            System.out.println("GENERATED TOKEN : " + token);



            response.put("message",
                    "Login successful");


            response.put("token",
                    token);



            return response;

        }


        response.put("message",
                "Invalid email or password");


        return response;

    }






    // GET ALL USERS

    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();

    }






    // GET USER BY ID

    @GetMapping("/{id}")
    public Optional<User> getUserById(
            @PathVariable Long id){

        return userService.getUserById(id);

    }






    // DELETE USER

    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable Long id){


        userService.deleteUser(id);


        return "User deleted successfully";

    }


}