package com.example.springhomework003.service;

import com.example.springhomework003.model.entity.Attendee;
import com.example.springhomework003.model.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {

    public List<Attendee> getAllAttendees(Integer pageNo, Integer pageSize);
    public Attendee getAttendeeById(int id);
    public Attendee addNewAttendee(AttendeeRequest attendeeRequest);
    public Attendee deleteAttendee(int id);
    public Attendee updateAttendee(int id, AttendeeRequest attendeeRequest);
}
