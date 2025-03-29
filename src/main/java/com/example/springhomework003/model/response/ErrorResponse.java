package com.example.springhomework003.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse extends ApiResponse<String>{
    private String message;
    private HttpStatus status;

}
