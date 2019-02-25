package com.blog.controller;

import com.blog.beans.Role;
import com.blog.beans.User;
import com.blog.repo.UserRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
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

    @PostMapping
    public String saveUser(
            @RequestParam("userId") User user,
            @RequestParam Map<String,String> form,
            @RequestParam String Username
    ){
        user.setUsername(Username);
        user.getRole().clear();
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRole().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
        return "redirect:/user";
    }

}
