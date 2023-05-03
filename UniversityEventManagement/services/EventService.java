package com.management.UniversityEventManagement.services;

import com.management.UniversityEventManagement.models.Event;
import com.management.UniversityEventManagement.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private IEventRepository iEventRepository;

    //create event
    public Event addEvent(Event newEvent){
        return iEventRepository.save(newEvent);
    }
    public List<Event> getAllEvent(){
        return iEventRepository.findAll();
    }

    //update event
    public void updateEvent(Integer id, Event newEvent){
        Event event = iEventRepository.findById(id).get();
        event.setEventName(newEvent.getEventName());
        event.setLocation(newEvent.getLocation());
        event.setStartTime(newEvent.getStartTime());
        event.setEndTime(newEvent.getEndTime());
        event.setDate(newEvent.getDate());

        iEventRepository.save(event);
    }

    //delete event
    public void deleteEvent(int id){
        iEventRepository.deleteById(id);
    }
}
