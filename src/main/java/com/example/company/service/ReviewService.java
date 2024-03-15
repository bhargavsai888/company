package com.example.company.service;

import java.util.List;

import com.example.company.entities.Review;

public interface ReviewService {

	
	 List<Review> getAllReviews(Long companyId);
	    boolean addReview(Long companyId, Review review);
	    Review getReview(Long companyId, Long reviewId);
	    boolean updateReview(Long companyId, Long reviewId, Review review);
	    boolean deleteReview(Long companyId, Long reviewId);

}
