package com.mukhina.spring.mvc.controllers;

import com.mukhina.spring.mvc.entity.User;
import com.mukhina.spring.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "list_of_users";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        model.addAttribute("user", new User());
        return "form_for_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/updateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "form_for_user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable (value = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }
}
