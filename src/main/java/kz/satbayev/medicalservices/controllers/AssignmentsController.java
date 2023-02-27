package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.Assignments;
import kz.satbayev.medicalservices.services.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assignments")
public class AssignmentsController {
    private final AssignmentService assignmentService;

    public AssignmentsController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public ResponseEntity<List<Assignments>> getAllAssignments(){
        return ResponseEntity.ok(assignmentService.getAll());
    }

    @PostMapping
    public ResponseEntity<Assignments> saveAssignment(@RequestBody Assignments assignments){
        return ResponseEntity.ok(assignmentService.save(assignments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignments> getAssignmentById(@PathVariable Long id){
        Optional<Assignments> assignments = assignmentService.getById(id);
        if(assignments.isPresent()){
            return ResponseEntity.ok(assignments.get());
        }
        else{
            throw new RuntimeException("Assignment with given id is not found");
        }
    }
}
