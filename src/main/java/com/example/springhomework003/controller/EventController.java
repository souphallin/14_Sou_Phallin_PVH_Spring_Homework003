package com.example.springhomework003.controller;

import com.example.springhomework003.model.entity.Event;
import com.example.springhomework003.model.request.EventRequest;
import com.example.springhomework003.model.response.ApiResponse;
import com.example.springhomework003.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<ApiResponse<List<Event>>> getAllEvents(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        ApiResponse<List<Event>> response = ApiResponse.<List<Event>>builder()
                .message("Get All Events Successfully!!!")
                .payload(eventService.getAllEvents(pageNo, pageSize))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Event>> getEventById(@PathVariable Integer id) {
        ApiResponse<Event> response = ApiResponse.<Event>builder()
                .message("Get Event By ID Successfully!!!")
                .payload(eventService.getEventById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Event>> deleteEventById(@PathVariable Integer id) {
        ApiResponse<Event> response = ApiResponse.<Event>builder()
                .message("Delete Event By ID Successfully!!!")
                .payload(eventService.deleteEventById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Event>> addNewEvent(@Valid @RequestBody EventRequest eventRequest) {
        ApiResponse<Event> response = ApiResponse.<Event>builder()
                .message("Add New Event Successfully!!!")
                .payload(eventService.addNewEvent(eventRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
