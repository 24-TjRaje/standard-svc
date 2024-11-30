package com.interview.micro.standard_svc.controller;

import com.interview.micro.standard_svc.entity.Standard;
import com.interview.micro.standard_svc.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/standard-svc/standards")
public class StandardController {

    @Autowired
    private StandardService standardService;

    // Create a new standard
    @PostMapping
    public ResponseEntity<Standard> createStandard( @RequestBody Standard standard) {
        return new ResponseEntity<>(standardService.createStandard(standard), HttpStatus.CREATED);
    }

    // Get all standards
    @GetMapping
    public List<Standard> getAllStandards() {
        return standardService.getAllStandards();
    }

    // Get a standard by ID
    @GetMapping("/{id}")
    public ResponseEntity<Standard> getStandardById(@PathVariable Long id) {
        Optional<Standard> standard = standardService.getStandardById(id);
        return standard.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update standard details
    @PutMapping("/{id}")
    public ResponseEntity<Standard> updateStandard(@PathVariable Long id,  @RequestBody Standard standardDetails) {
        Standard updatedStandard = standardService.updateStandard(id, standardDetails);
        return updatedStandard != null ? ResponseEntity.ok(updatedStandard)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete standard by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStandard(@PathVariable Long id) {
        return standardService.deleteStandard(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
