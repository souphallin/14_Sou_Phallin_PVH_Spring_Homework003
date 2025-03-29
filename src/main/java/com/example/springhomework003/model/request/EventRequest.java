package com.example.springhomework003.model.request;

import com.example.springhomework003.model.entity.Attendee;
import com.example.springhomework003.model.entity.Venue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private String eventDate;
    private Integer venue;
    private Integer attendee;
}
