package kz.satbayev.medicalservices.services;

import kz.satbayev.medicalservices.entity.Assignments;
import kz.satbayev.medicalservices.repository.AssignmentsRepository;
import kz.satbayev.medicalservices.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    AssignmentsRepository assignmentsRepository;
    DoctorRepository doctorRepository;

    public AssignmentService(AssignmentsRepository assignmentsRepository, DoctorRepository doctorRepository) {
        this.assignmentsRepository = assignmentsRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Assignments> getAll(){
        return assignmentsRepository.findAll();
    }

    public Assignments save(Assignments assignments){
        return assignmentsRepository.save(assignments);
    }

    public Optional<Assignments> getById(Long id){
        return assignmentsRepository.findById(id);
    }

    public List<Assignments> getByDoctorId(Long doctorId){
        return assignmentsRepository.findAllByDoctor_Id(doctorId);
    }
}
