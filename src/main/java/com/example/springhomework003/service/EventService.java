package com.example.springhomework003.service;

import com.example.springhomework003.model.entity.Event;
import com.example.springhomework003.model.request.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event getEventById(int id);
    Event deleteEventById(int id);
    Event addNewEvent(EventRequest eventRequest);
}
