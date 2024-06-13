package com.todocodeacademy.clinicaveterinaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_mascota;
    private String nombre_mascota;
    private String especie;
    private String raza;
    private String color;
    
    @OneToOne
    @JoinColumn (name="id_duenio", referencedColumnName = "id_duenio")
    private Duenio duenio;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre_mascota, String especie, 
            String raza, String color) {
        this.id_mascota = id_mascota;
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
    
}
