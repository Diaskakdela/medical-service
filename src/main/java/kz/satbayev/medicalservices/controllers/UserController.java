package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.Role;
import kz.satbayev.medicalservices.entity.User;
import kz.satbayev.medicalservices.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    UserRepository userRepository;
    UserController(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @GetMapping("/users")
    List<User> all(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newRole(@RequestBody User user){
        return userRepository.save(user);
    }
}
