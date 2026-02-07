package com.example.UserPortion.Services.Implementation;


import com.example.UserPortion.Dao.Entities.Hotel;
import com.example.UserPortion.Dao.Entities.Rating;
import com.example.UserPortion.Dao.Entities.User;
import com.example.UserPortion.Dao.Repository.UserRepository;
import com.example.UserPortion.Dto.UserRequest.PostRequest;
import com.example.UserPortion.Dto.UserResponse.GetResponse;
import com.example.UserPortion.Exceptions.UserNotFoundException;
import com.example.UserPortion.Services.Interface.UserService;

import com.example.UserPortion.external.Services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(PostRequest postRequest) {
        try {
            User user = new User();
            user.setName(postRequest.getName());
            user.setEmail(postRequest.getEmail());
            user.setAbout(postRequest.getAbout());

            return userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<GetResponse> getalluser() {
        List<User> userList = userRepository.findAll();
        List<GetResponse> getResponses = new ArrayList<>();
        GetResponse getResponse;
        try {
            for (User user : userList) {
                getResponse = new GetResponse();
                getResponse.setId(user.getId());
                getResponse.setName(user.getName());
                getResponse.setEmail(user.getEmail());
                getResponse.setAbout(user.getAbout());
                Rating[] ratingsOfUser=  restTemplate.getForObject("http://RATING-SERVICE/rating/getByUserid/"+user.getId(), Rating[].class);
                logger.info("{}",ratingsOfUser);
                List<Rating> ratingArray=Arrays.stream(ratingsOfUser).toList();

               List<Rating> ratingList= ratingArray.stream().map(rating -> {

                   ResponseEntity<Hotel> hotelArrayList = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/get/"+rating.getHotelId(),Hotel.class);
                   Hotel hotel=hotelArrayList.getBody();
                   logger.info("response status code:{}",hotelArrayList.getStatusCode());
                   rating.setHotel(hotel);
                     return rating;
                }).collect(Collectors.toList());
                getResponse.setRatings(ratingList);
                getResponses.add(getResponse);
            }

            return getResponses;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public GetResponse getUser(String id) {
        try {
            GetResponse getResponse = new GetResponse();
            User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with this id is not found" + " :" + id));
            getResponse.setId(user.getId());
            getResponse.setName(user.getName());
            getResponse.setEmail(user.getEmail());
            getResponse.setAbout(user.getAbout());
            getResponse.setRatings(user.getRatings());


            // fetch ratings from rating portion
//            localhost:8092/rating/getByUserid/0c2487fb-7ed9-4b01-b0f7-da49b29e5d0a
            Rating[] ratingsOfUser=  restTemplate
                    .getForObject("http://RATING-SERVICE/rating/getByUserid/"+user.getId(), Rating[].class);
            logger.info("{}",ratingsOfUser);
            List<Rating> ratingArray=Arrays.stream(ratingsOfUser).toList();

            List<Rating> ratingList= ratingArray.stream().map(rating -> {

//            ResponseEntity<Hotel> hotelArrayList = restTemplate
//                    .getForEntity("http://HOTEL-SERVICE/hotel/get/"+rating.getHotelId(),Hotel.class);
                Hotel hotel=hotelService.getHotel(rating.getHotelId());
 //               logger.info("response status code:{}",hotelArrayList.getStatusCode());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());
            getResponse.setRatings(ratingList);

            return getResponse;
        } catch (Exception e) {
            throw e;
        }


    }

}
