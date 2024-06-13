package com.todocodeacademy.clinicaveterinaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Duenio {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_duenio;
    private String dni;
    private String nombre_duenio;
    private String apellido_duenio;
    private String celular;

    public Duenio() {
    }

    public Duenio(Long id_duenio, String dni, String nombre_duenio, String apellido_duenio, String celular) {
        this.id_duenio = id_duenio;
        this.dni = dni;
        this.nombre_duenio = nombre_duenio;
        this.apellido_duenio = apellido_duenio;
        this.celular = celular;
    }
    
}
