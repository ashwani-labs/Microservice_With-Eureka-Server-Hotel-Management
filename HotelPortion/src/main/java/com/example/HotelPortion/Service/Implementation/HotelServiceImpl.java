package com.example.HotelPortion.Service.Implementation;

import com.example.HotelPortion.Dao.Entity.Hotel;
import com.example.HotelPortion.Dao.Repository.HotelRepository;
import com.example.HotelPortion.Dto.Request.ApiRequest;
import com.example.HotelPortion.Dto.Response.GetResponse;
import com.example.HotelPortion.Exception.ResourceNotFoundException;
import com.example.HotelPortion.Service.Interface.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel Create(ApiRequest apiRequest) {
        try {
            Hotel hotel = new Hotel();
            hotel.setName(apiRequest.getName());
            hotel.setLocation(apiRequest.getLocation());
            hotel.setAbout(apiRequest.getAbout());
            return hotelRepository.save(hotel);
        }catch(Exception e){
            throw e;
        }

    }

    @Override
    public List<GetResponse> getAll() {
        try {
            List<GetResponse> getResponses = new ArrayList<>();
            GetResponse getResponse = new GetResponse();

            List<Hotel> hotelList = hotelRepository.findAll();
            for (Hotel hotel : hotelList) {
                getResponse.setId(hotel.getId());
                getResponse.setName(hotel.getName());
                getResponse.setLocation(hotel.getLocation());
                getResponse.setAbout(hotel.getAbout());
                getResponses.add(getResponse);
            }
            return getResponses;
        }catch(Exception e){
            throw  e;
        }
    }

    @Override
    public GetResponse get(String id) {
        try {
            GetResponse getResponse = new GetResponse();
            Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found" + " " + id));
            getResponse.setId(hotel.getId());
            getResponse.setName(hotel.getName());
            getResponse.setLocation(hotel.getLocation());
            getResponse.setAbout(hotel.getAbout());

            return getResponse;
        }catch(Exception e){
            throw e;
        }
    }
}
