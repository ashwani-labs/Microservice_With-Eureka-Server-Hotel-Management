package com.example.RatingPortion.Controller;

import com.example.RatingPortion.Dao.Entity.Rating;
import com.example.RatingPortion.Dto.Request.PostRequest;
import com.example.RatingPortion.Dto.Response.GetResponse;
import com.example.RatingPortion.Service.Interface.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;
    @PostMapping("/save")
    public ResponseEntity<Rating> create(@RequestBody PostRequest postRequest){
        Rating rating=ratingService.create(postRequest);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<GetResponse>> getAllRating(){
        List<GetResponse> ratingList=ratingService.getAllRatings();
        return new ResponseEntity<>(ratingList,HttpStatus.OK);
    }

    @GetMapping("/getByUserid/{userId}")
    public ResponseEntity<List<GetResponse>> getRatingByuserId(@PathVariable String userId){
        List<GetResponse> ratingList=ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(ratingList,HttpStatus.OK);
    }

    @GetMapping("/hotelid/{hotelId}")
    public ResponseEntity<List<GetResponse>> getRatingsByHotelId(@PathVariable String hotelId){
        List<GetResponse> ratingList=ratingService.getratingByHotelId(hotelId);
        return new ResponseEntity<>(ratingList,HttpStatus.OK);

    }

}
