package com.example.springhomework003.model.response;

import com.example.springhomework003.model.entity.Attendee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse <T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime timestamp;

//    public ApiResponse(String message, T payload, HttpStatus status, LocalDateTime timestamp) {
//        this.message = message;
//        this.payload = payload;
//        this.status = status;
//        this.timestamp = timestamp;
//    }
    public ApiResponse(T payload) {
        this.payload = payload;
        this.message = "Success";
        this.status = HttpStatus.OK;
        this.timestamp = LocalDateTime.now();
    }
}

