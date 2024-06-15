package com.grupo7.hospital.controller;

import com.grupo7.hospital.DTO.UserRegisteredDTO;
import com.grupo7.hospital.model.User;
import com.grupo7.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/CadastroUsuario")
public class RegistroController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegisteredDTO userRegistrationDto() {
        return new UserRegisteredDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "CadastroUsuario";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegisteredDTO registrationDto) {
        userService.save(registrationDto);
        return "redirect:/login";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "GerenciarUsuarios";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        UserRegisteredDTO registrationDto = new UserRegisteredDTO();
        registrationDto.setId(user.getId());
        registrationDto.setName(user.getName());
        registrationDto.setEmail_id(user.getEmail());
        registrationDto.setPassword(user.getPassword()); // Handle password appropriately in real applications
        registrationDto.setPerfil(user.getPerfil().iterator().next().getPerfil()); // Assuming one profile per user
        registrationDto.setEspecialidade(user.getEspecialidade());

        model.addAttribute("user", registrationDto);
        return "CadastroUsuario";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, @ModelAttribute("user") UserRegisteredDTO registrationDto) {
        registrationDto.setId(id);
        userService.save(registrationDto);
        return "redirect:/CadastroUsuario/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/CadastroUsuario/list";
    }
}
