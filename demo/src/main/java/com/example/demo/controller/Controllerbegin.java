package com.example.demo.controller;


import com.example.demo.domain.Persona;
import com.example.demo.service.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@Slf4j
public class Controllerbegin {

    @Autowired
    private IPersonaService personaService;
    @Value("${properties.value}")
    public String mensaje;

    @GetMapping("/")
    public String begin(Model model, Model mPersona) {
        List<Persona> personas = (List<Persona>) personaService.listarPersonas();
        mPersona.addAttribute("personas", personas);
        var saludar = "holamundo con timeleaf kcrs....reload activated " + mensaje;
        model.addAttribute("saludar", saludar);
        log.info("ejecutado de forma correcta el proceso  holamundo ");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar( Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar( Persona persona) {
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{email}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";

    }

    @GetMapping("/delete/{email}")
    public String elimninar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }

}
