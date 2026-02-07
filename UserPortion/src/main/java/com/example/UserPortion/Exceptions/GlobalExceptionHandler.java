package com.example.UserPortion.Exceptions;


import com.example.UserPortion.Dto.UserResponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //To tell UserNotFoundException arises
    @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<ApiResponse> handlerUserNotFoundException(UserNotFoundException ex){
        String message= ex.getMessage();
       ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
   }
}
