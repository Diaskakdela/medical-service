package kz.satbayev.medicalservices.controllers;

import kz.satbayev.medicalservices.entity.Disease;
import kz.satbayev.medicalservices.repository.DiseaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disease")
public class DiseaseController {
    DiseaseRepository diseaseRepository;

    public DiseaseController(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }
    @GetMapping
    public ResponseEntity<List<Disease>> getAllDisease(){
        return ResponseEntity.ok(diseaseRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disease> getDiseaseById(@PathVariable Long id){
        return ResponseEntity.ok(diseaseRepository.findById(id).orElseThrow(()->new RuntimeException("Not found")));
    }

    @PostMapping
    public  ResponseEntity<Disease> saveDisease(@RequestBody Disease disease){
        return ResponseEntity.ok(diseaseRepository.save(disease));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disease> updateDisease(@PathVariable Long id, @RequestBody Disease disease){
        Disease disease1 = diseaseRepository.findById(id).orElseThrow(()-> new RuntimeException("Disease not found"));

        disease1.setName(disease.getName());

        return ResponseEntity.ok(diseaseRepository.save(disease));
    }

    @DeleteMapping("/{id}")
    public void deleteDisease(@PathVariable Long id){
        diseaseRepository.deleteById(id);
    }
}
