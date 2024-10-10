package com.webtest.web.controller;

import com.webtest.web.dto.ClubDto;
import com.webtest.web.dto.EventDto;
import com.webtest.web.models.Event;
import com.webtest.web.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService)
    {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model)
    {
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("events/{id}")
    public String viewEvent(@PathVariable("id") Long id, Model model)
    {
        EventDto event = eventService.findByEventId(id);
        model.addAttribute("event", event);
        return "events-detail";
    }

    @GetMapping("/events/{clubId}/new")
    private String createEventForm(@PathVariable("clubId") long clubId, Model model)
    {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @GetMapping("/events/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model)
    {
        EventDto eventDto = eventService.findByEventId(id);
        model.addAttribute("event", eventDto);
        return "events-edit";
    }

    @PostMapping("/events/{id}/edit")
    public String update(@PathVariable("id") Long id,
                         @Valid @ModelAttribute("event") EventDto event,
                         BindingResult result,
                         Model model)
    {
        if (result.hasErrors()){
            model.addAttribute("event", event);
            return "events-edit";
        }

        EventDto eventDto = eventService.findByEventId(id);
        event.setId(id);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "redirect:/events";
    }
    @PostMapping("events/{clubId}")
    public String create(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDto eventDto, Model model)
    {
        eventService.createEvent(clubId, eventDto);
        return "redirect:/clubs/" + clubId;
    }

    @GetMapping("/events/{id}/delete")
    public String delete(@PathVariable("id") long id)
    {
        eventService.delete(id);
        return "redirect:/events";
    }
}
