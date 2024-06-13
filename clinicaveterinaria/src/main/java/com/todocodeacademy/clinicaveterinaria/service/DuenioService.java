package com.todocodeacademy.clinicaveterinaria.service;

import com.todocodeacademy.clinicaveterinaria.model.Duenio;
import com.todocodeacademy.clinicaveterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service        
public class DuenioService implements IDuenioService {
    
    @Autowired
    private IDuenioRepository duenioRepo;

    @Override
    public List<Duenio> getDuenios() {
        List <Duenio> listaDuenios = duenioRepo.findAll();
        return listaDuenios;
    }

    @Override
    public void saveDuenio(Duenio duenio) {
        duenioRepo.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id_duenio) {
        duenioRepo.deleteById(id_duenio);
    }

    @Override
    public Duenio findDuenio(Long id_duenio) {
        Duenio duenio = duenioRepo.findById(id_duenio).orElse(null);
        return duenio;
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
    }
   
}