package com.example.HotelPortion.Exception;

import lombok.Data;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Data
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {

    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
