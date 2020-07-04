package eu.marcellofabbri.trendz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import eu.marcellofabbri.trendz.model.dto.ProteinIntakeRequestCreate;
import eu.marcellofabbri.trendz.model.dto.ProteinIntakeResponse;
import eu.marcellofabbri.trendz.service.IntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.marcellofabbri.trendz.model.entity.ProteinIntake;
import eu.marcellofabbri.trendz.repository.ProteinIntakeRepository;

@RestController
@RequestMapping("/api")

public class ProteinIntakeController {

    @Autowired
    ProteinIntakeRepository proteinIntakeRepository;

    @Autowired
    IntakeService intakeService;

    @GetMapping("intakes")
    public List<ProteinIntake> getAllIntakes() {
        System.out.println("getting all intakes... ");

        List<ProteinIntake> list = new ArrayList<>();
        Iterable<ProteinIntake> trackers = proteinIntakeRepository.findAll();
        trackers.forEach(list::add);
        return list;
    }

    @PostMapping("intakes")
    public ProteinIntakeResponse createIntake(@RequestBody ProteinIntakeRequestCreate request) {
       return intakeService.createIntake(request);
    }

    @GetMapping("/intakes/{id}")
    public ResponseEntity<ProteinIntake> getIntake(@PathVariable("id") Long id) {
        System.out.println("Get intake by id...");

        Optional<ProteinIntake> intakeData = proteinIntakeRepository.findById(id);
        if (intakeData.isPresent()) {
            return new ResponseEntity<>(intakeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/intakes/{id}")
    public ResponseEntity<ProteinIntake> updateIntake(@PathVariable("id") Long id, @RequestBody ProteinIntake proteinIntake) {
        System.out.println("Updating record with id " + proteinIntake.getId() + "... ");

        Optional<ProteinIntake> intakeData = proteinIntakeRepository.findById(id);
        if (intakeData.isPresent()) {
            ProteinIntake savedIntake = intakeData.get();
            savedIntake.setCreatedAt(proteinIntake.getCreatedAt());
            savedIntake.setMeasurement(proteinIntake.getMeasurement());

            ProteinIntake updatedIntake = proteinIntakeRepository.save(savedIntake);
            return new ResponseEntity<>(updatedIntake, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/intakes/{id}")
    public ResponseEntity<String> deleteIntake(@PathVariable("id") Long id) {
        System.out.println("Delete intake with ID = " + id + "...");

        try {
            proteinIntakeRepository.deleteById(id);
        } catch(Exception e) {
            return new ResponseEntity<>("Failed to delete", HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>("Record has been deleted", HttpStatus.OK);
    }
}