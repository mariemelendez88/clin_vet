package com.todocodeacademy.clinicaveterinaria.controller;

import com.todocodeacademy.clinicaveterinaria.dto.MascoDuenioDTO;
import com.todocodeacademy.clinicaveterinaria.model.Mascota;
import com.todocodeacademy.clinicaveterinaria.service.IMascotaService;
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
public class MascotaController {
    
    @Autowired
    private IMascotaService mascotaServ;
    
    //2. CRUD/ABML de mascotas
    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas(){
        return mascotaServ.getMascotas();
    }
    
    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota mascota){
        mascotaServ.saveMascota(mascota);
        return "La mascota fue creada correctamente";
    }
    
    @DeleteMapping("/mascotas/borrar/{id_mascota}")
    public String deleteMascota(@PathVariable Long id_mascota){
        mascotaServ.deleteMascota(id_mascota);
        return "La mascota fue eliminada correctamente";
    }
    
    @PutMapping("/mascotas/editar")
    public Mascota editMascota(@RequestBody Mascota mascota){
        mascotaServ.editMascota(mascota);
        return mascotaServ.findMascota(mascota.getId_mascota());
    }
    
    //3. Obtener el listado de todas las mascotas de especie="perro" y raza="caniche"
    @GetMapping("/mascotas/traer/caniches")
    public List<Mascota> getPerrosCaniches(){
        return mascotaServ.getPerrosCaniches();
    }
    
    //4. Obtener un listado de los siguientes datos combinados de una mascota y su dueño
    @GetMapping("/mascotas/traer/duenios")
    public List <MascoDuenioDTO> getMascoDueniosDTO(){
        return mascotaServ.getMascoDueniosDTO();
    }
}
