package com.example.event_streaming.service;

import com.example.event_streaming.model.Event;
import com.example.event_streaming.repository.EventRepository;

import java.util.List;

public class EventService {

    private final EventRepository eventRepository;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // POST /events

    public Event createEvents(Event event) {
        return eventRepository.save(event);
    }

    // GET /events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // GET /events/recent


    // GET /events/summary
}
