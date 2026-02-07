package com.example.HotelPortion.Dao.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @Column(name="hotelId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "hotelName")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "about")
    private String about;
}
