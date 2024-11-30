package com.interview.micro.standard_svc.service;

import com.interview.micro.standard_svc.entity.Standard;
import com.interview.micro.standard_svc.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandardService {

    @Autowired
    private StandardRepository standardRepository;

    // Create a new standard
    public Standard createStandard(Standard standard) {
        return standardRepository.save(standard);
    }

    // Get all standards
    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    // Get a standard by ID
    public Optional<Standard> getStandardById(Long id) {
        return standardRepository.findById(id);
    }

    // Update a standard by ID
    public Standard updateStandard(Long id, Standard standardDetails) {
        if (standardRepository.existsById(id)) {
            standardDetails.setId(id);
            return standardRepository.save(standardDetails);
        }
        return null;
    }

    // Delete a standard by ID
    public boolean deleteStandard(Long id) {
        if (standardRepository.existsById(id)) {
            standardRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

