package com.example.springhomework003.controller;

import com.example.springhomework003.exception.NotFoundException;
import com.example.springhomework003.model.entity.Attendee;
import com.example.springhomework003.model.request.AttendeeRequest;
import com.example.springhomework003.model.response.ApiResponse;
import com.example.springhomework003.service.AttendeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }
    @GetMapping("/getAllAttendees")
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendees(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        List<Attendee> attendees = attendeeService.getAllAttendees(pageNo, pageSize);
        ApiResponse<List<Attendee>> response = ApiResponse.<List<Attendee>>builder()
                .message("Get All Attendees Successfully!!!")
                .payload(attendees)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getAttendeeById(@PathVariable Integer id) {
        Attendee attendee = attendeeService.getAttendeeById(id);
//        try {
            if (attendee == null) {
                throw new NotFoundException("Attendee id " + id + " Not Found!!!");
            }
            return new ResponseEntity<>(new ApiResponse<>(attendee), HttpStatus.OK);
//        } catch (NotFoundException e) {
//            return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
//        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> addNewAttendee(@Valid @RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Add New Attendee Successfully!!!")
                .payload(attendeeService.addNewAttendee(attendeeRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendee>> deleteAttendee(@PathVariable Integer id) {
        Attendee attendee = attendeeService.deleteAttendee(id);
        if (attendee == null) {
            throw new NotFoundException("Attendee id " + id + " Not Found!!!");
        }
        return new ResponseEntity<>(new ApiResponse<>(attendee), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendee(@PathVariable Integer id, @Valid @RequestBody AttendeeRequest attendeeRequest) {
        Attendee attendee = attendeeService.updateAttendee(id, attendeeRequest);
        if (attendee == null) {
            throw new NotFoundException("Attendee id " + id + " Not Found!!!");
        }
        return new ResponseEntity<>(new ApiResponse<>(attendee), HttpStatus.OK);
    }
}
