package com.example.UserPortion.Services.Interface;

import com.example.UserPortion.Dao.Entities.User;
import com.example.UserPortion.Dto.UserRequest.PostRequest;
import com.example.UserPortion.Dto.UserResponse.GetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser(PostRequest postRequest);

    List<GetResponse> getalluser();

    GetResponse getUser(String id);


}


