package com.example.UserPortion.Dto.UserRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private String name;

    private String email;

    private String about;


}
