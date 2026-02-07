package com.example.UserPortion.external.Services;

import com.example.UserPortion.Dao.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/get/{id}")
    Hotel getHotel(@PathVariable("id") String id);
    @GetMapping("/hotel/getAll")
    Hotel getHotel();
}
