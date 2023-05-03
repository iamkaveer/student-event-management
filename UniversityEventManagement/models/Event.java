package com.management.UniversityEventManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @NotBlank(message = "Event name cannot be blank")
    private String eventName;

    @NotBlank(message = "Location of event cannot be blank")
    private String location;

    @NotBlank(message = "Start time cannot be blank")
    private LocalDateTime startTime;

    @NotBlank(message = "End time cannot be blank")
    private LocalDateTime endTime;

    @NotBlank(message = "Date cannot be blank")
    private LocalDateTime date;
}
