package com.example.RatingPortion.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetResponse {
    private String ratingId;

    private String userId;

    private String hotelId;

    private int rating;

    private String feedback;
}
