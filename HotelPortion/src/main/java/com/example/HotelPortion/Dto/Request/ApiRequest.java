package com.example.HotelPortion.Dto.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequest {

    private String name;

    private String location;

    private String about;
}
