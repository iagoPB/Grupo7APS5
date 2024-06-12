package com.grupo7.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.grupo7.hospital.model.User;
import com.grupo7.hospital.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/CadastroUsuario";
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user,
                           @RequestParam String role) {
        user.setRole(role);
        userService.save(user);
        return "redirect:/users/gerenciar";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/ListarUsuarios";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users/EditarUsuarios";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user,
                             @RequestParam String role) {
        user.setRole(role);
        userService.save(user);
        return "redirect:/users/gerenciar";
    }

    @GetMapping("/gerenciar")
    public String manageUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/GerenciarUsuarios";
    }
}
