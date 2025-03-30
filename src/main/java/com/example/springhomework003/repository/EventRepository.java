package com.example.springhomework003.repository;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import com.example.springhomework003.model.entity.Event;
import com.example.springhomework003.model.request.EventRequest;
import org.apache.ibatis.annotations.*;

import javax.swing.*;
import java.util.List;

@Mapper
public interface EventRepository {
    @Select("""
        select * from events
        offset #{pageSize} * (#{pageNo} - 1)
        limit #{pageSize}
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
    List<Event> getAllEvents(Integer pageNo, Integer pageSize);

    @Select("""
        select * from events where event_id = #{id}
    """)
    @ResultMap("getMapper")
    Event getEventById(Integer id);

    @Select("""
        delete from events where event_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Event deleteEventById(int id);

    @Select("""
        insert into events (event_name, event_date, venue_id)
        values (#{request.eventName}, #{request.eventDate}, #{request.venue}) 
        returning *
    """)
    Event addNewEvent(@Param("request") EventRequest eventRequest);

    @Select("""
        update events
        set event_name = #{request.eventName}, event_date = #{request.eventDate}, venue_id = #{request.venue}
        where event_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Event updateEventById(Integer id, @Param("request") EventRequest eventRequest);
}
