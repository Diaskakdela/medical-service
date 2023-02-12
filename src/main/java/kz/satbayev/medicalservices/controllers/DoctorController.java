package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.Doctor;
import kz.satbayev.medicalservices.exception.EntityNotFoundException;
import kz.satbayev.medicalservices.payload.ErrorResponse;
import kz.satbayev.medicalservices.repository.DoctorRepository;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController extends CustomExceptionHandler {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id){
        return doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }


    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

        existingDoctor.setDoctorSpecialization(doctor.getDoctorSpecialization());
        existingDoctor.setUser(doctor.getUser());

        return ResponseEntity.ok(doctorRepository.save(existingDoctor));
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);
    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<?> EntityNotFoundExceptionHandler(EntityNotFoundException e){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse EntityNotFoundExceptionHandler(EntityNotFoundException e){
        return new ErrorResponse(e.getMessage());
    }

}
