package com.example.springhomework003.service;

import com.example.springhomework003.model.entity.Venue;
import com.example.springhomework003.model.request.VenueRequest;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenues();
    Venue getVenueById(int id);
    Venue addNewVenue(VenueRequest venueRequest);
    Venue deleteVenueById(int id);
    Venue updateVenueById(int id, VenueRequest venueRequest);
}
