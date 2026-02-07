package com.example.RatingPortion.Service.Interface;

import com.example.RatingPortion.Dao.Entity.Rating;
import com.example.RatingPortion.Dto.Request.PostRequest;
import com.example.RatingPortion.Dto.Response.GetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    //create
   Rating create(PostRequest postRequest);


    //Get all ratings
     List<GetResponse> getAllRatings();

    //Get ratings By UserId
    List<GetResponse> getRatingByUserId(String userId);

    //Get all By Hotel
    List<GetResponse> getratingByHotelId(String hotelId);
}
