package com.webtest.web.service.impl;

import com.webtest.web.dto.EventDto;
import com.webtest.web.models.Club;
import com.webtest.web.models.Event;
import com.webtest.web.repository.ClubRepository;
import com.webtest.web.repository.EventRepository;
import com.webtest.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.webtest.web.mapper.EventMapper.mapToEvent;
import static com.webtest.web.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }
    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long id) {
        Event event = eventRepository.findById(id).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto)
    {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
