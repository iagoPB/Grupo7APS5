package com.grupo7.hospital.controller;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.model.User;
import com.grupo7.hospital.service.ConsultaService;
import com.grupo7.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private UserService userService;

    @GetMapping("/gerenciar")
    public String gerenciarConsultas(Model model) {
        model.addAttribute("consultas", consultaService.findAll());
        return "GerenciarConsultas";
    }

    @GetMapping("/paciente")
    public String listarConsultasDoPaciente(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userService.findByEmail(email);
        if (user != null) {
            List<Consulta> consultas = consultaService.findByPaciente(user);
            model.addAttribute("consultas", consultas);
            model.addAttribute("pacienteNome", user.getName());
        }

        return "PacienteConsultas";
    }

  

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("pacientes", userService.findUsersByPerfil("PACIENTE"));
        model.addAttribute("medicos", userService.findUsersByPerfil("MEDICO"));
        return "CriarConsulta";
    }

    @PostMapping("/new")
    public String createConsulta(@ModelAttribute Consulta consulta) {
        User paciente = userService.findById(consulta.getPaciente().getId());
        User medico = userService.findById(consulta.getMedico().getId());

        if (paciente != null && medico != null) {
            consulta.setPaciente(paciente);
            consulta.setMedico(medico);
            consultaService.save(consulta);
            return "redirect:/consultas/gerenciar";
        } else {
            return "redirect:/consultas/new?error=true";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Consulta consulta = consultaService.findById(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("pacientes", userService.findUsersByPerfil("PACIENTE"));
        model.addAttribute("medicos", userService.findUsersByPerfil("MÉDICO"));
        return "EditarConsulta";
    }

    @PostMapping("/edit/{id}")
    public String editConsulta(@PathVariable("id") int id, @ModelAttribute Consulta consulta) {
        User paciente = userService.findById(consulta.getPaciente().getId());
        User medico = userService.findById(consulta.getMedico().getId());

        if (paciente != null && medico != null) {
            consulta.setId(id);
            consulta.setPaciente(paciente);
            consulta.setMedico(medico);
            consultaService.save(consulta);
            return "redirect:/consultas/gerenciar";
        } else {
            return "redirect:/consultas/edit/" + id + "?error=true";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteConsulta(@PathVariable("id") int id) {
        consultaService.deleteById(id);
        return "redirect:/consultas/gerenciar";
    }
}
