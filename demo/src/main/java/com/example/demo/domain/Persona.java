package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Data
@Table(name = "PERSONA")
public class Persona  {

    private String nombre;
    private String apellido;
    @Id
    private String email;
    private String telefono;
}
