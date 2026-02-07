package com.example.HotelPortion.Controller;

import com.example.HotelPortion.Dao.Entity.Hotel;
import com.example.HotelPortion.Dto.Request.ApiRequest;
import com.example.HotelPortion.Dto.Response.GetResponse;
import com.example.HotelPortion.Service.Interface.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
     HotelService hotelService;
       @PostMapping("/create")
      public ResponseEntity<Hotel> createHotel(@RequestBody ApiRequest apiRequest){
          Hotel hotel1=hotelService.Create(apiRequest);
          return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
      }
      @GetMapping("/getAll")
      public ResponseEntity<List<GetResponse>> getAll(){
          List<GetResponse> List=hotelService.getAll();
          return new ResponseEntity<>(List,HttpStatus.OK);
      }
      @GetMapping("/get/{id}")
      public ResponseEntity<GetResponse> getHotel(@PathVariable  String id){
          GetResponse getResponse=hotelService.get(id);
          return new ResponseEntity<>(getResponse,HttpStatus.OK);
      }
}
