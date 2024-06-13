package com.todocodeacademy.clinicaveterinaria.controller;

import com.todocodeacademy.clinicaveterinaria.model.Duenio;
import com.todocodeacademy.clinicaveterinaria.service.IDuenioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DuenioController {
    
    @Autowired
    private IDuenioService duenioServ;
    
    //1. CRUD/ABML de duenios
    @GetMapping("/duenios/traer")
    public List<Duenio> getDuenios(){
        return duenioServ.getDuenios();
    }
    
    @PostMapping("/duenios/crear")
    public String saveDuenio(@RequestBody Duenio duenio){
        duenioServ.saveDuenio(duenio);
        return "El duenio fue creado correctamente";
    }
    
    @DeleteMapping("/duenios/borrar/{id_duenio}")
    public String deleteDuenio(@PathVariable Long id_duenio){
        duenioServ.deleteDuenio(id_duenio);
        return "El duenio fue eliminado correctamente";
    }
    
    @PutMapping("/duenios/editar")
    public Duenio editDuenio(@RequestBody Duenio duenio){
        duenioServ.editDuenio(duenio);
        return duenioServ.findDuenio(duenio.getId_duenio());
    }
    
}
