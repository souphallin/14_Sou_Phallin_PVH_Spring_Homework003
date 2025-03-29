package com.example.springhomework003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer eventId;
    private String eventName;
    private String eventDate;
    private Venue venue;
    private Attendee attendee;
}
