package com.webtest.web.controller;

import com.webtest.web.dto.ClubDto;
import com.webtest.web.models.Club;
import com.webtest.web.service.ClubService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String index(Model model)
    {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }
    @GetMapping("/clubs/create")
    public String create(Model model)
    {
        Club club = new Club();
        System.out.println(club);
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("clubs/store")
    public String store(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.store(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model)
    {
        ClubDto club = clubService.findClubById(id);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @GetMapping("/clubs/{id}")
    public String detail(@PathVariable("id") long id, Model model)
    {
        ClubDto clubDto = clubService.findClubById(id);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    @GetMapping("/clubs/{id}/delete")
    public String delete(@PathVariable("id") Long id)
    {
        clubService.delete(id);
        return "redirect:/clubs";
    }

    @PostMapping("/clubs/{id}/edit")
    public String update(@PathVariable("id") Long id,
                         @Valid @ModelAttribute("club") ClubDto club,
                         BindingResult result
                         )
    {
        if (result.hasErrors()){
            return "clubs-edit";
        }
        club.setId(id);
        clubService.update(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model)
    {
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

}
