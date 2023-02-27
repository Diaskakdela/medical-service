package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.DoctorSpecialization;
import kz.satbayev.medicalservices.repository.DoctorSpecializationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctorspecitalizations")
public class DoctorSpecializationController {
    DoctorSpecializationRepository doctorSpecializationRepository;

    public DoctorSpecializationController(DoctorSpecializationRepository doctorSpecializationRepository) {
        this.doctorSpecializationRepository = doctorSpecializationRepository;
    }

    @GetMapping
    public List<DoctorSpecialization> getAllSpecializations(){
        return doctorSpecializationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorSpecialization> getSpecializationById(@PathVariable Long id){
        return ResponseEntity.ok(doctorSpecializationRepository.findById(id).orElseThrow(()->new RuntimeException("Specialization not found")));
    }

    @PostMapping
    public ResponseEntity<DoctorSpecialization> saveSpecialization(@RequestBody DoctorSpecialization doctorSpecialization){
        return ResponseEntity.ok(doctorSpecializationRepository.save(doctorSpecialization));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorSpecialization> updateSpecialization(@PathVariable Long id, @RequestBody DoctorSpecialization doctorSpecialization){
        DoctorSpecialization doctorSpecialization1 = doctorSpecializationRepository.findById(id).orElseThrow(()-> new RuntimeException("Doctor specialization not found"));

        doctorSpecialization1.setName(doctorSpecialization.getName());
        doctorSpecialization1.setDiseases(doctorSpecialization.getDiseases());

        return ResponseEntity.ok(doctorSpecializationRepository.save(doctorSpecialization1));
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialization(@PathVariable Long id){
        doctorSpecializationRepository.delete(doctorSpecializationRepository.findById(id).orElseThrow(()->new RuntimeException("Specialization not found")));
    }
}
