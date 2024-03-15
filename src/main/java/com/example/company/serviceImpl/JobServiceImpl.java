package com.example.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.entities.Job;
import com.example.company.repository.JobRepository;
import com.example.company.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	@Override
	public List<Job> getAllJobs() {
		List<Job> jobs=jobRepository.findAll();
		
		return jobs;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		jobRepository.save(job);
	}
	@Override
	public Job getJob(Long id) {
		// TODO Auto-generated method stub
		Optional<Job> job=jobRepository.findById(id);
		
		if(job.isPresent()) {
			return job.get();
		}
		return null;
	}
	@Override
	public boolean deleteJob(Long id) {
		boolean isDeleted;
		try {
			jobRepository.deleteById(id);
			 isDeleted=true;

		}catch (Exception e) {
			 isDeleted=false;
		}
		
		
		return isDeleted;
	}
	@Override
	public boolean updateJob(Long id,Job job) {
		Optional<Job> Job=jobRepository.findById(id);
		if(Job.isPresent()) {
			Job optionalJob=Job.get();
			
			optionalJob.setTitle(job.getTitle());
			optionalJob.setDescription(job.getDescription());
			optionalJob.setMinSalary(job.getMinSalary());
			optionalJob.setMaxSalary(job.getMaxSalary());
			optionalJob.setLocation(job.getLocation());

			jobRepository.save(optionalJob);
			return true;
			
		}
		return false;
	}

}
