package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public void submitRating(Rating rating) {
        if (rating != null && rating.getRatingId() > 0) {
            ratingRepository.addRating(rating);
        } else {
            System.out.println("Invalid Rating Details. Cannot Submit.");
        }
    }

    public List<Rating> fetchAllRatings() {
        return ratingRepository.getAllRatings();
    }

    public void updateRating(Rating rating) {
        if (rating != null && rating.getRatingId() > 0) {
            ratingRepository.updateRating(rating);
        } else {
            System.out.println("Invalid Rating Details. Cannot Update.");
        }
    }

    public void deleteRating(int ratingId) {
        if (ratingId > 0) {
            ratingRepository.deleteRating(ratingId);
        } else {
            System.out.println(" Invalid Rating ID. Cannot Delete.");
        }
    }

    public void modifyRating(Rating rating) {
    }

    public void removeRating(int ratingId) {
    }

    public void addRating(Rating rate) {
    }

    public void updateRating(int ratingId, int newRating, String review) {
    }
}



