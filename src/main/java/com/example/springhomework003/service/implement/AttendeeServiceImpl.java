package com.example.springhomework003.service.implement;

import com.example.springhomework003.model.entity.Attendee;
import com.example.springhomework003.model.request.AttendeeRequest;
import com.example.springhomework003.repository.AttendeeRepository;
import com.example.springhomework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAllAttendees(Integer pageNo, Integer pageSize) {
        return attendeeRepository.getAllAttendees(pageNo, pageSize);
    }

    @Override
    public Attendee getAttendeeById(int id) {
        return attendeeRepository.getAttendeeById(id);
    }

    @Override
    public Attendee addNewAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.addNewAttendee(attendeeRequest);
    }

    @Override
    public Attendee deleteAttendee(int id) {
        return attendeeRepository.deleteAttendee(id);
    }

    @Override
    public Attendee updateAttendee(int id, AttendeeRequest attendeeRequest) {
        return attendeeRepository.updateAttendee(id, attendeeRequest);
    }


}
