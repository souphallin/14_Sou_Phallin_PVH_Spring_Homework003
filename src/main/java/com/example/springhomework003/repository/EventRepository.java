package com.example.springhomework003.repository;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import com.example.springhomework003.model.entity.Event;
import com.example.springhomework003.model.request.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {
    @Select("""
        select * from events
    """)
    @Results(id = "getMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    many = @Many(select = "com.example.springhomework003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendee", column = "event_id",
                    many = @Many(select = "com.example.springhomework003.repository.AttendeeRepository.getAttendeeByEventId"))
    })
    List<Event> getAllEvents();

    @Select("""
        select * from events where event_id = #{id}
    """)
    @ResultMap("getMapper")
    Event getEventById(int id);

    @Select("""
        delete from events where event_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Event deleteEventById(int id);

    @Select("""
        insert into events
        values (default, #{request.event_name}, #{request.event_date}, #{request.venue_id}, #{request.attendee_id}) returning *
    """)
    Event addNewEvent(@Param("request") EventRequest eventRequest);

    @Select("""
        insert into event_attendee values (#{attendeeId}, #{eventId})
    """)
    Event addEventToEventAttendee(@Param("attendeeId") int attendeeId, @Param("venueId") int venueId);
}
