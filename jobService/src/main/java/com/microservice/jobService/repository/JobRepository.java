package com.microservice.jobService.repository;

import com.microservice.jobService.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

