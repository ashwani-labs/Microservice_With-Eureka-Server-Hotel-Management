package com.example.HotelPortion.Dto.Response;


import com.example.HotelPortion.Dao.Entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetResponse extends Hotel {
    private String id;
    private String name;

    private String location;

    private String about;
}
