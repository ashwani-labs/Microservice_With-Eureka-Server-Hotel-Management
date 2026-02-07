package com.example.HotelPortion.Service.Interface;

import com.example.HotelPortion.Dao.Entity.Hotel;
import com.example.HotelPortion.Dto.Request.ApiRequest;
import com.example.HotelPortion.Dto.Response.GetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    Hotel Create(ApiRequest apiRequest);

    List<GetResponse> getAll();

    GetResponse get(String id);
}
