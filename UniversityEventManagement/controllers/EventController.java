package com.management.UniversityEventManagement.controllers;

import com.management.UniversityEventManagement.exceptions.ClassNotFoundExceptions;
import com.management.UniversityEventManagement.models.Event;
import com.management.UniversityEventManagement.repository.IEventRepository;
import com.management.UniversityEventManagement.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private IEventRepository iEventRepository;

    //create a new event
    @PostMapping("/create-event")
    public ResponseEntity<Event> addEvent(@RequestBody @Valid Event newEvent){
        return new ResponseEntity<>(eventService.addEvent((newEvent)), HttpStatus.CREATED);
    }

    //get all event
    @GetMapping("/get-all-events")
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(iEventRepository.findAll());
    }
    //update event
    @PutMapping("/event-update/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable int id, @RequestBody Event newEvent)  {
        Event event = iEventRepository.findById(id).get();
        if(event != null){
            eventService.updateEvent(id,newEvent);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("updated");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
    }

    //delete
    @DeleteMapping("/delete-event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id){
        Event event = iEventRepository.findById(id).get();
        if(event != null){
            eventService.deleteEvent(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
    }
}
