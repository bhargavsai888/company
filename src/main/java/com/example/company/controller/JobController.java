/**
 * 
 */
package com.example.company.controller;

import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
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

import com.example.company.entities.Job;
import com.example.company.service.JobService;


/**
 * @author bharg
 *
 */
@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@GetMapping
	public ResponseEntity<List<Job>> getAllJobs(){
		List<Job> Jobs=jobService.getAllJobs();
		return new ResponseEntity<>(Jobs, HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job){
		jobService.createJob(job);
		return new ResponseEntity<>("Job created successfully",HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> getJob(@PathVariable Long id){
		Job job=jobService.getJob(id);
		return new ResponseEntity<Job>(job, HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id){
		boolean isDeleted=jobService.deleteJob(id);
		if(isDeleted) {
			return new ResponseEntity<String>("Job deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);

		
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job job){
		boolean valid = jobService.updateJob(id,job);
		if(valid) {
			return new ResponseEntity<String>("Job updated successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Job not found",HttpStatus.NOT_FOUND);
		
	}
	
}
