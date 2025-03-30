package com.example.springhomework003.service.implement;

import com.example.springhomework003.model.entity.Event;
import com.example.springhomework003.model.request.EventRequest;
import com.example.springhomework003.repository.AttendeeRepository;
import com.example.springhomework003.repository.EventRepository;
import com.example.springhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;
    public EventServiceImpl(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Event> getAllEvents(Integer pageNo, Integer pageSize) {
        return eventRepository.getAllEvents(pageNo, pageSize);
    }
    @Override
    public Event getEventById(Integer id) {
        return eventRepository.getEventById(id);
    }
    @Override
    public Event deleteEventById(int id) {
        return eventRepository.deleteEventById(id);
    }
    @Override
    public Event addNewEvent(EventRequest eventRequest) {
        Event event = eventRepository.addNewEvent(eventRequest);
        for (Integer attendeeId : eventRequest.getAttendee()){
            attendeeRepository.addEventAndAttendee(event.getEventId(), attendeeId);
        }
        return eventRepository.getEventById(event.getEventId());
    }

    @Override
    public Event updateEventById(Integer eventId, EventRequest eventRequest) {
        Event event = eventRepository.updateEventById(eventId, eventRequest);
        attendeeRepository.deleteEventAndAttendee(eventId);
        for (Integer attendeeId : eventRequest.getAttendee()){
            attendeeRepository.addEventAndAttendee(eventId, attendeeId);
        }
        return getEventById(event.getEventId());
    }
}
