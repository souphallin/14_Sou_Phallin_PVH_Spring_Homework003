package com.example.springhomework003.controller;

import com.example.springhomework003.model.entity.Venue;
import com.example.springhomework003.model.request.VenueRequest;
import com.example.springhomework003.model.response.ApiResponse;
import com.example.springhomework003.service.VenueService;
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
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues() {
        ApiResponse<List<Venue>> response = ApiResponse.<List<Venue>>builder()
                .message("Get All Venues Successfully!!!")
                .payload(venueService.getAllVenues())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable Integer id) {
        ApiResponse<Venue> getVenueById = ApiResponse.<Venue>builder()
                .message("Get Venue By ID Successfully!!!")
                .payload(venueService.getVenueById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(getVenueById);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> addNewVenue(@RequestBody VenueRequest venueRequest) {
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
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .message("Delete Venue Successfully!!!")
                .payload(venueService.deleteVenueById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@PathVariable Integer id, @RequestBody VenueRequest venueRequest) {
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .message("Update Venue Successfully!!!")
                .payload(venueService.updateVenueById(id, venueRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
