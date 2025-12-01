package com.example.event_streaming.controller;

import com.example.event_streaming.model.Event;
import com.example.event_streaming.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping
    public ResponseEntity<Event> post(@Valid @RequestBody Event event) {
        Event saved = eventService.createEvents(event);
        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }

    // recent

}

