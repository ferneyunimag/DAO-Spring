package com.example.demo.controller;


import com.example.demo.domain.Persona;
import com.example.demo.service.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String agregar(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona",persona);
        return "modificar";
    }

}
