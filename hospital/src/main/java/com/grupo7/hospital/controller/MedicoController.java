package com.grupo7.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo7.hospital.model.Medico;
import com.grupo7.hospital.service.HospitalService;
import com.grupo7.hospital.service.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private HospitalService hospitalService;

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/new")
    public String newMedico(Model model) {
        model.addAttribute("medico", new Medico());
        return "medico/form"; // Nome do template "form.html" em "src/main/resources/templates/medico/"
    }

    @PostMapping
    public String saveMedico(Medico medico) {
        medicoService.save(medico);
        return "redirect:/medicos/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("consultas", hospitalService.findAllConsultas());
        model.addAttribute("pacientes", hospitalService.findAllPacientes());
        return "medico/dashboard"; // Nome do template "dashboard.html" em "src/main/resources/templates/medico/"
    }

    @GetMapping("/gerenciar-consultas")
    public String gerenciarConsultas() {
        return "medico/gerenciar-consultas"; // Nome do template "gerenciar-consultas.html" em "src/main/resources/templates/medico/"
    }
}