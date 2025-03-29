package com.example.springhomework003.service.implement;

import com.example.springhomework003.model.entity.Venue;
import com.example.springhomework003.model.request.VenueRequest;
import com.example.springhomework003.repository.VenueRepository;
import com.example.springhomework003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;
    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenues(Integer pageNo, Integer pageSize) {
        return venueRepository.getAllVenues(pageNo, pageSize);
    }

    @Override
    public Venue getVenueById(int id) {
        return venueRepository.getVenueById(id);
    }

    @Override
    public Venue addNewVenue(VenueRequest venueRequest) {
        return venueRepository.addNewVenue(venueRequest);
    }

    @Override
    public Venue deleteVenueById(int id) {
        return venueRepository.deleteVenueById(id);
    }

    @Override
    public Venue updateVenueById(int id, VenueRequest venueRequest) {
        return venueRepository.updateVenueById(id, venueRequest);
    }
}
