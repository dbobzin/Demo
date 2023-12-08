package com.microservice.jobService.controller;

import com.microservice.jobService.model.Job;
import com.microservice.jobService.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public Job postJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @GetMapping("/{jobId}")
    public Job getJob(@PathVariable Long jobId) {
        return jobService.getJobById(jobId);
    }

    @PutMapping("/{jobId}")
    public Job updateJob(@PathVariable Long jobId, @RequestBody Job updatedJob) {
        return jobService.updateJob(jobId, updatedJob);
    }

    @DeleteMapping("/{jobId}")
    public Job deleteJob(@PathVariable Long jobId) {
        return jobService.deleteJob(jobId);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

}

