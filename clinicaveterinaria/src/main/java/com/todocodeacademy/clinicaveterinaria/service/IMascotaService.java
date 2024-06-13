package com.todocodeacademy.clinicaveterinaria.service;

import com.todocodeacademy.clinicaveterinaria.dto.MascoDuenioDTO;
import com.todocodeacademy.clinicaveterinaria.model.Mascota;
import java.util.List;

public interface IMascotaService {
    
    //2. CRUD/ABML de mascotas
    
    //método para traer a todos los Mascotas
    public List<Mascota> getMascotas();
    
    //alta
    public void saveMascota(Mascota mascota);
    
    //baja
    public void deleteMascota(Long id_mascota);
    
    //lectura de un solo objeto
    public Mascota findMascota(Long id_mascota);

    //editar
    public void editMascota(Mascota mascota);
    
    //3. Obtener el listado de todas las mascotas de especie="perro" y raza="caniche"
    public List<Mascota> getPerrosCaniches();
    
    //4. Obtener un listado de los siguientes datos combinados de una mascota y su dueño
    public List<MascoDuenioDTO> getMascoDueniosDTO();
    
}
