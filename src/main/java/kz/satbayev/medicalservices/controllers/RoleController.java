package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.Role;
import kz.satbayev.medicalservices.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    private RoleRepository roleRepository;

    RoleController(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @GetMapping("/roles")
    List<Role> all(){
        return roleRepository.findAll();
    }

    @PostMapping("/roles")
    Role newRole(@RequestBody Role role){
        return roleRepository.save(role);
    }

}
