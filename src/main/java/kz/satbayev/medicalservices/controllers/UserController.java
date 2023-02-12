package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.User;
import kz.satbayev.medicalservices.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@CrossOrigin("*")
public class UserController {
    UserRepository userRepository;
    UserController(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @GetMapping("/users")
    List<User> all() throws Exception{
        Thread.sleep(5);
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newRole(@RequestBody User user){
        return userRepository.save(user);
    }
}
