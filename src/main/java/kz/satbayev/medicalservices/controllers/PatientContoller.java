package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.Patient;
import kz.satbayev.medicalservices.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class PatientContoller {
    private final PatientRepository patientRepository;

    public PatientContoller(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }


}
