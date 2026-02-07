package com.example.UserPortion.Dto.UserResponse;

import com.example.UserPortion.Dao.Entities.Rating;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetResponse {
    private String id;

    private String name;

    private String email;

    private String about;


    private List<Rating> ratings=new ArrayList<>();
}
