package com.interview.micro.standard_svc.repository;

import com.interview.micro.standard_svc.entity.Standard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandardRepository extends JpaRepository<Standard, Long> {
}
