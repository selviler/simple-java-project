package com.webtest.web.service;

import com.webtest.web.dto.EventDto;
import com.webtest.web.models.Event;

import java.util.List;

import static com.webtest.web.mapper.EventMapper.mapToEvent;

public interface EventService{
    void createEvent(Long clubId, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findByEventId(Long id);
    void updateEvent(EventDto eventDto);
    void delete(Long id);
}
