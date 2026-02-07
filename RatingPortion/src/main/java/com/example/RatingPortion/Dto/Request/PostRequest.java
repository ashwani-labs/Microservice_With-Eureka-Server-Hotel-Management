package com.example.RatingPortion.Dto.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String userId;

    private String hotelId;

    private int rating;

    private String feedback;
}
