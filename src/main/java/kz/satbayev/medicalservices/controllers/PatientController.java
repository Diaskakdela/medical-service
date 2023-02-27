package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.Patient;
import kz.satbayev.medicalservices.exception.ResourceNotFoundException;
import kz.satbayev.medicalservices.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient not found"));
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientRepository.save(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updateDoctor(@PathVariable Long id, @RequestBody Patient patient){
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        existingPatient.setPatientChild(patient.isPatientChild());
        existingPatient.setUser(patient.getUser());

        return ResponseEntity.ok(patientRepository.save(existingPatient));
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new RuntimeException("patient not found"));
        patientRepository.delete(patient);
    }
}
