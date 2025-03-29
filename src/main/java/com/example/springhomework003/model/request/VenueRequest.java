package com.example.springhomework003.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    @NotBlank(message = "VenueName must not be Null!!!")
    private String venueName;
    @NotBlank(message = "Location must not be Null!!!")
    private String location;
}
