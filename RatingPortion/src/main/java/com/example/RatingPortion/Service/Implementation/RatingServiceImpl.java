package com.example.RatingPortion.Service.Implementation;

import com.example.RatingPortion.Dao.Entity.Rating;
import com.example.RatingPortion.Dao.Repository.RatingRepository;
import com.example.RatingPortion.Dto.Request.PostRequest;
import com.example.RatingPortion.Dto.Response.GetResponse;
import com.example.RatingPortion.Service.Interface.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
     @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating create(PostRequest postRequest) {
        try {
            Rating rating = new Rating();
            rating.setRating(postRequest.getRating());
            rating.setFeedback(postRequest.getFeedback());
            rating.setHotelId(postRequest.getHotelId());
            rating.setUserId(postRequest.getUserId());

            return ratingRepository.save(rating);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<GetResponse> getAllRatings() {
        try {
            List<GetResponse> getResponseList = new ArrayList<>();
            GetResponse getResponse = new GetResponse();
            List<Rating> rating = ratingRepository.findAll();

            for (Rating rating1 : rating) {
                getResponse.setRatingId(rating1.getRatingId());
                getResponse.setRating(rating1.getRating());
                getResponse.setUserId(rating1.getUserId());
                getResponse.setHotelId(rating1.getHotelId());
                getResponse.setFeedback(rating1.getFeedback());

                getResponseList.add(getResponse);
            }
            return getResponseList;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<GetResponse> getRatingByUserId(String userId) {
        try {
            List<GetResponse> getResponseList = new ArrayList<>();
            GetResponse getResponse = new GetResponse();
            List<Rating> rating = ratingRepository.findByUserId(userId);

            for (Rating rating1 : rating) {
                getResponse.setRatingId(rating1.getRatingId());
                getResponse.setRating(rating1.getRating());
                getResponse.setUserId(rating1.getUserId());
                getResponse.setHotelId(rating1.getHotelId());
                getResponse.setFeedback(rating1.getFeedback());

                getResponseList.add(getResponse);
            }
            return getResponseList;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<GetResponse> getratingByHotelId(String hotelId) {
        try {
            List<GetResponse> getResponseList = new ArrayList<>();
            GetResponse getResponse = new GetResponse();
            List<Rating> rating = ratingRepository.findByHotelId(hotelId);

            for (Rating rating1 : rating) {
                getResponse.setRatingId(rating1.getRatingId());
                getResponse.setRating(rating1.getRating());
                getResponse.setUserId(rating1.getUserId());
                getResponse.setHotelId(rating1.getHotelId());
                getResponse.setFeedback(rating1.getFeedback());

                getResponseList.add(getResponse);
            }
            return getResponseList;
        }catch(Exception e){
            throw e;
        }
    }
}
