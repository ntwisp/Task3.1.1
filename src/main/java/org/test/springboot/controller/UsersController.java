package org.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.test.springboot.service.UserService;
import org.test.springboot.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @RequestMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping
    public RedirectView saveUser(@ModelAttribute User user, RedirectAttributes attributes) {
        userService.saveUser(user);
        attributes.addFlashAttribute("message", "User saved successfully");
        return new RedirectView("/users");
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getUser(id);
        userService.saveUser(user);
        model.addAttribute("user", user);
        return "form";
    }

    @RequestMapping("/delete/{id}")
    public RedirectView deleteUser(@PathVariable Long id, RedirectAttributes attributes) {
        userService.deleteUser(id);
        attributes.addFlashAttribute("message", "User deleted successfully");
        return new RedirectView("/users");
    }
}