package com.example.springhomework003.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    @NotBlank(message = "AttendeeName must not be Null!!!")
    private String attendeeName;
    @Email(message = "Please follow the right format of Email!!!")
    private String email;
}
