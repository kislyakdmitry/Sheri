package com.blog.controller;

import com.blog.beans.Role;
import com.blog.beans.User;
import com.blog.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserListController {
    private final UserRepo userRepo;

    public UserListController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String UserList(Model model) {
        List<User> userList = userRepo.findAll();

        model.addAttribute("users", userList);
        return "UserList";
    }

    @GetMapping("{user}")
    public String editUser(
            @PathVariable User user, Model model) {
        model.addAttribute("user", user);
        Set<Role> roles = Arrays.stream(Role.values()).collect(Collectors.toSet());

        model.addAttribute("roles",roles);
        return "UserEdit";
    }

}
