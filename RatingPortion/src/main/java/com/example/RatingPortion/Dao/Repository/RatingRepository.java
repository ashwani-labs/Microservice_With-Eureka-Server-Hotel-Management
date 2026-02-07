package com.example.RatingPortion.Dao.Repository;

import com.example.RatingPortion.Dao.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {

    //Custom Finder Methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
