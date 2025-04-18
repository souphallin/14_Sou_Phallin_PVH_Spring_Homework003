package com.example.springhomework003.controller;

import com.example.springhomework003.exception.NotFoundException;
import com.example.springhomework003.model.entity.Venue;
import com.example.springhomework003.model.request.VenueRequest;
import com.example.springhomework003.model.response.ApiResponse;
import com.example.springhomework003.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {
    private final VenueService venueService;
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        ApiResponse<List<Venue>> response = ApiResponse.<List<Venue>>builder()
                .message("Get All Venues Successfully!!!")
                .payload(venueService.getAllVenues(pageNo, pageSize))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable Integer id) {
        Venue venue = venueService.getVenueById(id);
        if (venue == null) {
            throw new NotFoundException("Venue " + id + " Not Found");
        }
        return new ResponseEntity<>(new ApiResponse<>(venue), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> addNewVenue(@Valid @RequestBody VenueRequest venueRequest) {
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .message("Add New Venue Successfully!!!")
                .payload(venueService.addNewVenue(venueRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Venue>> deleteVenueById(@PathVariable Integer id) {
        Venue venue = venueService.deleteVenueById(id);
        if (venue == null) {
            throw new NotFoundException("Venue " + id + " Not Found");
        }
        return new ResponseEntity<>(new ApiResponse<>(venue), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@PathVariable Integer id, @Valid @RequestBody VenueRequest venueRequest) {
        Venue venue = venueService.updateVenueById(id, venueRequest);
        if (venue == null) {
            throw new NotFoundException("Venue " + id + " Not Found");
        }
        return new ResponseEntity<>(new ApiResponse<>(venue), HttpStatus.OK);
    }
}
