package com.webtest.web.controller;

import com.webtest.web.dto.RegistrationDto;
import com.webtest.web.models.UserEntity;
import com.webtest.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model)
    {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/login")
    public String login()
    {

    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model)
    {
        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());

        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }

        UserEntity existingUserName = userService.findByUserName(user.getUsername());
        if(existingUserName != null && existingUserName.getUsername() != null && !existingUserName.getUsername().isEmpty()) {
            return "redirect:/register?fail";
        }
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/clubs?success";
    }
}
