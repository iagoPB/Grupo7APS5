package com.grupo7.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.grupo7.hospital.model.Medico;
import com.grupo7.hospital.model.Paciente;
import com.grupo7.hospital.service.ConsultaService;
import com.grupo7.hospital.service.MedicoService;
import com.grupo7.hospital.service.PacienteService;


@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/new")
    public String newPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/form"; // Nome do template "form.html" em "src/main/resources/templates/paciente/"
    }

    @PostMapping
    public String savePaciente(Paciente paciente) {
        Paciente savedPaciente = pacienteService.save(paciente);
        return "redirect:/pacientes/dashboard/" + savedPaciente.getId();
    }

    @GetMapping("/dashboard/{id}")
    public String dashboard(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.findById(id);
        if (paciente == null) {
            return "redirect:/pacientes/new";
        }
        model.addAttribute("paciente", paciente);
        model.addAttribute("consultas", consultaService.findByPacienteId(id));
        return "paciente/dashboard"; // Nome do template "dashboard.html" em "src/main/resources/templates/paciente/"
    }
}
