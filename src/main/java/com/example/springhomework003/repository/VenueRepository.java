package com.example.springhomework003.repository;

import com.example.springhomework003.model.entity.Venue;
import com.example.springhomework003.model.request.VenueRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("""
        select * from venues
        offset #{pageSize} * (#{pageNo} - 1)
        limit #{pageSize}
    """)
    @Results(id= "getMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    List<Venue> getAllVenues(Integer pageNo, Integer pageSize);

    @Select("""
        select * from venues where venue_id = #{id}
    """)
    @ResultMap("getMapper")
    Venue getVenueById(int id);

    @Select("""
        insert into venues values (default, #{request.venueName}, #{request.location}) returning *
    """)
    @ResultMap("getMapper")
    Venue addNewVenue(@Param("request") VenueRequest venueRequest);

    @Select("""
        delete from venues where venue_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Venue deleteVenueById(int id);

    @Select("""
        update venues 
        set venue_name = #{request.venueName}, location = #{request.location} 
        where venue_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Venue updateVenueById(int id, @Param("request") VenueRequest venueRequest);
}
