package com.example.UserPortion.Controller;

import com.example.UserPortion.Dao.Entities.User;
import com.example.UserPortion.Dto.UserRequest.PostRequest;
import com.example.UserPortion.Dto.UserResponse.GetResponse;
import com.example.UserPortion.Dto.UserResponse.UpdateResponse;
import com.example.UserPortion.Services.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //Create The User
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody PostRequest postRequest){
        User user1=userService.saveUser(postRequest);
        return new ResponseEntity(user1, HttpStatus.CREATED);
    }

    //Get all User
    @GetMapping("/getAll")
    public ResponseEntity<List<GetResponse>> getallUser(){
        List<GetResponse> getResponse=userService.getalluser();
        return new ResponseEntity<>(getResponse,HttpStatus.OK);
    }

    //Get User By id
    @GetMapping("/{id}")
    public ResponseEntity<GetResponse> getByid(@PathVariable(value="id") String id){
        GetResponse getResponse=userService.getUser(id);
        return new ResponseEntity<>(getResponse,HttpStatus.OK);
    }
}
