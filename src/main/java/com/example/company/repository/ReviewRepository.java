package com.example.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.company.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findByCompanyId(Long companyId);
}
