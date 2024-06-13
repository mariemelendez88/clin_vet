package com.todocodeacademy.clinicaveterinaria.service;

import com.todocodeacademy.clinicaveterinaria.dto.MascoDuenioDTO;
import com.todocodeacademy.clinicaveterinaria.model.Mascota;
import com.todocodeacademy.clinicaveterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService{
    
    @Autowired
    private IMascotaRepository mascotaRepo;

    //2. CRUD/ABML de mascotas
    @Override
    public List<Mascota> getMascotas() {
        List <Mascota> listaMascotas = mascotaRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepo.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascotaRepo.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        Mascota mascota = mascotaRepo.findById(id_mascota).orElse(null);
        return mascota;
    }

    @Override
    public void editMascota(Mascota mascota) {
        this.saveMascota(mascota);
    }
    
    //3. Obtener el listado de todas las mascotas de especie="perro" y raza="caniche"
    @Override
    public List<Mascota> getPerrosCaniches(){
        String word1 = "perro";
        String word2;
        String word3 = "caniche";
        String word4;
        
        List <Mascota> listaMascotas = this.getMascotas();
        List <Mascota> listaPerrosCaniches = new ArrayList<Mascota>();
        
        for (Mascota mascota : listaMascotas) {
            word2 = mascota.getEspecie();
            word4 = mascota.getRaza();
            if (word2.equalsIgnoreCase(word1) && word4.equalsIgnoreCase(word3)) {
                listaPerrosCaniches.add(mascota);
            }
        }
    return listaPerrosCaniches;
    }
    
    //4. Obtener un listado de los siguientes datos combinados de una mascota y su dueño
    @Override
    public List<MascoDuenioDTO> getMascoDueniosDTO(){
        //Se obtienen las listas de mascotas
        List <Mascota> listaMascotas = this.getMascotas();
        //Se crea la lista de mascotas/dueños que sera el return
        List<MascoDuenioDTO> listaMascoDuenio = new ArrayList<MascoDuenioDTO>();
        
        //Usamos un for para recorrer toda la lista de mascotas
        for (Mascota mascota : listaMascotas){
            
            //Se crea el objeto de mascota/dueño que se añadirá luego a la lista.
            MascoDuenioDTO masco_duenio = new MascoDuenioDTO();
            
            //Se llena el objeto con la data
            masco_duenio.setNombre_mascota(mascota.getNombre_mascota());
            masco_duenio.setEspecie(mascota.getEspecie());
            masco_duenio.setRaza(mascota.getRaza());
            masco_duenio.setNombre_duenio(mascota.getDuenio().getNombre_duenio());
            masco_duenio.setApellido_duenio(mascota.getDuenio().getApellido_duenio());
            
            //Se añade el objeto creado a la lista que devolvera el programa
            listaMascoDuenio.add(masco_duenio);
            
        }
        
        return listaMascoDuenio;
        
    }
    
}
