package com.example.springhomework003.model.request;

import com.example.springhomework003.model.entity.Attendee;
import com.example.springhomework003.model.entity.Venue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    @NotBlank(message = "EventName must not be Null!!!")
    private String eventName;
    @NotBlank(message = "EventDate must not be Null!!!")
    private String eventDate;
    @NotBlank(message = "Please input the Venue ID!!!")
    private Integer venue;
    @NotBlank(message = "Please input the Attendee ID!!!")
    private List<Integer> attendee;
}
