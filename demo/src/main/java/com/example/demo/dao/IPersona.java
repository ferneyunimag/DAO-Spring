package com.example.demo.dao;

import com.example.demo.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersona extends CrudRepository<Persona, String> {

}
