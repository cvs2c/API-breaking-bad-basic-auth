package dev.marshallBits.breakingBadApi.controllers;

import dev.marshallBits.breakingBadApi.dto.CreateUserDTO;
import dev.marshallBits.breakingBadApi.models.User;
import dev.marshallBits.breakingBadApi.services.user.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    @Autowired
    UserServiceImp userService;

    @PostMapping("/singup")
    @ResponseStatus(HttpStatus.CREATED)
    public User singUp(@RequestBody CreateUserDTO user){
        return userService.registerUser(user);
    }

}
