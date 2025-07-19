package com.example.signupapp.controller;

import com.example.signupapp.model.User;
import com.example.signupapp.util.FileStorageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SignupController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user) {
        FileStorageUtil.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = FileStorageUtil.readUsers();
        model.addAttribute("users", users);
        return "userlist";
    }
}