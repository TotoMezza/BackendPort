package com.portfolio.tm.Service;

import com.portfolio.tm.Interface.IPersonaService;
import com.portfolio.tm.Repository.IPersonaRepository;
import com.portfolio.tm.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void guardarPersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
}
