package com.example.springhomework003.controller;

import com.example.springhomework003.model.entity.Attendee;
import com.example.springhomework003.model.request.AttendeeRequest;
import com.example.springhomework003.model.response.ApiResponse;
import com.example.springhomework003.service.AttendeeService;
import org.apache.ibatis.annotations.Param;
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
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@PathVariable Integer id) {
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Get Attendee By ID Successfully!!!")
                .payload(attendeeService.getAttendeeById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> addNewAttendee(@RequestBody AttendeeRequest attendeeRequest) {
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
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Delete Attendee Successfully!!!")
                .payload(attendeeService.deleteAttendee(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendee(@PathVariable Integer id, @RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Update Attendee Successfully!!!")
                .payload(attendeeService.updateAttendee(id, attendeeRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
