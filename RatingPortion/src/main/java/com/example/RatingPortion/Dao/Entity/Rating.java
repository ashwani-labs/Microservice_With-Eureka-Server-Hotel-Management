package com.example.RatingPortion.Dao.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="rating")
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @Column(name="ratingId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ratingId;
    @Column(name="userId")
    private String userId;
    @Column(name="hotelId")
    private String hotelId;
    @Column(name = "rating")
    private int rating;
    @Column(name = "feedback")
    private String feedback;
}
