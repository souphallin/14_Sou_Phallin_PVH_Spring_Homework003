package com.example.springhomework003.service.implement;

import com.example.springhomework003.model.entity.Event;
import com.example.springhomework003.model.request.EventRequest;
import com.example.springhomework003.repository.EventRepository;
import com.example.springhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents(Integer pageNo, Integer pageSize) {
        return eventRepository.getAllEvents(pageNo, pageSize);
    }
    @Override
    public Event getEventById(int id) {
        return eventRepository.getEventById(id);
    }
    @Override
    public Event deleteEventById(int id) {
        return eventRepository.deleteEventById(id);
    }
    @Override
    public Event addNewEvent(EventRequest eventRequest) {
        return eventRepository.addNewEvent(eventRequest);
    }
}
