package com.microservice.jobService.service;

import com.microservice.jobService.model.Job;
import com.microservice.jobService.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job updateJob(Long jobId, Job updatedJob) {
        Job existingJob = jobRepository.findById(jobId).orElse(null);
        if (existingJob != null) {
            // Update relevant fields
            existingJob.setDescription(updatedJob.getDescription());
            existingJob.setPayRate(updatedJob.getPayRate());
            // Save the updated job
            return jobRepository.save(existingJob);
        }
        return null; // Handle non-existing job
    }

    public Job deleteJob(Long jobId) {
        Job jobToDelete = jobRepository.findById(jobId).orElse(null);
        if (jobToDelete != null) {
            jobRepository.deleteById(jobId);
        }
        return jobToDelete;
    }
}

