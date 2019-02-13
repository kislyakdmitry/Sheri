package com.blog.controller;

import com.blog.beans.User;
import com.blog.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserListController {
    private final UserRepo userRepo;

    public UserListController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String UserList(Model model){
        List<User> userList = userRepo.findAll();

        model.addAttribute("users",userList);
        return "UserList";
    }
}
