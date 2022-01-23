package com.example.demo.service;

import com.example.demo.dao.IPersona;
import com.example.demo.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersona iPersona;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) iPersona.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        iPersona.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        iPersona.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return iPersona.findById(persona.getEmail()).orElse(null);
    }
}
