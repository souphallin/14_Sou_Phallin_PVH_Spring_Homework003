package com.example.springhomework003.exception;

import com.example.springhomework003.model.response.ApiResponse;
import com.example.springhomework003.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ApiResponse<?>> handleNotFoundException(NotFoundException e) {
//        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Not Found");
        problemDetail.setProperty("Timestamp", LocalDateTime.now());
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
        problemDetail.setTitle("Server Error");
        problemDetail.setProperty("Timestamp", LocalDateTime.now());
        return problemDetail;
//        return new ResponseEntity<>(new ErrorResponse("Something Went Wrong, Try Again Later!!!", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
