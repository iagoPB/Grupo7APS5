package com.grupo7.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo7.hospital.model.User;
import com.grupo7.hospital.repository.UserRepository;

@Controller
@RequestMapping("/GerenciarUsuarios")
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
    public String displayDashboard(Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "GerenciarUsuarios";
    }
	
	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		return users.getName();
	}
	
}

