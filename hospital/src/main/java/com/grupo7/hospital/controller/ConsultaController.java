package com.grupo7.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.service.ConsultaService;
import com.grupo7.hospital.service.HospitalService;
import com.grupo7.hospital.service.MedicoService;
import com.grupo7.hospital.service.PacienteService;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;
    
	@Autowired
	private HospitalService hospitalService;

    @GetMapping("/new")
    public String newConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("medicos", medicoService.findAll());
        model.addAttribute("pacientes", pacienteService.findAll());
        return "consultas/form"; // Nome do template "form.html" em "src/main/resources/templates/consultas/"
    }

    @PostMapping
    public String saveConsulta(@ModelAttribute Consulta consulta) {
        consultaService.saveOrUpdate(consulta);
        return "redirect:/consultas/list";
    }

    @GetMapping("/edit/{id}")
    public String editConsulta(@PathVariable Long id, Model model) {
        Consulta consulta = consultaService.findById(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("medicos", medicoService.findAll());
        model.addAttribute("pacientes", pacienteService.findAll());
        return "consultas/form"; // Nome do template "form.html" em "src/main/resources/templates/consultas/"
    }

    @GetMapping("/delete/{id}")
    public String deleteConsulta(@PathVariable Long id) {
        consultaService.deleteById(id);
        return "redirect:/consultas/list";
    }

    @GetMapping("/list")
    public String listConsultas(Model model) {
        model.addAttribute("consultas", consultaService.findAll());
        return "consultas/list"; // Nome do template "list.html" em "src/main/resources/templates/consultas/"
    }
}