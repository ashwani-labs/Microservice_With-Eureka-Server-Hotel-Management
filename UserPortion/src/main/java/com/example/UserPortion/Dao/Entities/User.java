package com.example.UserPortion.Dao.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name = "about")
    private String about;

    //other Properties of User

    @Transient
   private List<Rating> ratings=new ArrayList<>();

}
