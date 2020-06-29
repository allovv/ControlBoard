package com.springapp.controllers;

import com.springapp.entities.Roles;
import com.springapp.entities.User;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService; //TODO: ???

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user, Map<String, Object> model) {
        User userDB = userService.findByEmail(user.getEmail());
        if (userDB != null) {
            model.put("errorMessage", "Пользователь с таким email уже зарегистрирован!");
            return "registration";
        }

        Set<Roles> roles = new HashSet<>();
        roles.add(Roles.USER);
        userService.save(user);

        return "redirect:/login";
    }

}
