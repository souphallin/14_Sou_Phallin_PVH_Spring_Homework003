package com.example.springhomework003.repository;

import com.example.springhomework003.model.entity.Attendee;
import com.example.springhomework003.model.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Select("""
    select * from attendees
    offset #{pageSize} * (#{pageNo}-1)
    limit #{pageSize}
    """)
    @Results(id = "getMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })
    List<Attendee> getAllAttendees(Integer pageNo, Integer pageSize);

    @Select("""
    select * from attendees where attendee_id = #{id}
    """)
    @ResultMap("getMapper")
    Attendee getAttendeeById(int id);

    @Select("""
        insert into attendees values (default, #{request.attendeeName}, #{request.email}) returning *
    """)
    @ResultMap("getMapper")
    Attendee addNewAttendee(@Param("request") AttendeeRequest attendeeRequest);

    @Select("""
        delete from attendees where attendee_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Attendee deleteAttendee(int id);

    @Select("""
        update attendees 
        set attendee_name=#{request.attendeeName}, email=#{request.email} 
        where attendee_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Attendee updateAttendee(int id, @Param("request") AttendeeRequest attendee);

    @Select("""
        select a.attendee_id, a.attendee_name, a.email
        from attendees a
        inner join event_attendee ea
        on a.attendee_id = ea.attendee_id
        where event_id = #{eventId}
    """)
    @ResultMap("getMapper")
    Attendee getAttendeeByEventId(Integer eventId);

    @Insert("""
        INSERT INTO event_attendee (event_id, attendee_id)
        VALUES (#{eventId}, #{attendeeId}) returning *
    """)
    void addEventAndAttendee(Integer eventId, Integer attendeeId);

    @Select("""
        delete from event_attendee where event_id = #{eventId}
    """)
    void deleteEventAndAttendee(Integer eventId);
}
