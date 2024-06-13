package com.todocodeacademy.clinicaveterinaria.service;

import com.todocodeacademy.clinicaveterinaria.model.Duenio;
import java.util.List;

public interface IDuenioService {
    
    //método para traer a todos los Duenios
    public List<Duenio> getDuenios();
    
    //alta
    public void saveDuenio(Duenio duenio);
    
    //baja
    public void deleteDuenio(Long id_duenio);
    
    //lectura de un solo objeto
    public Duenio findDuenio(Long id_duenio);

    //editar
    public void editDuenio(Duenio duenio);
    
}
