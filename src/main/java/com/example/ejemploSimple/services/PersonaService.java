package com.example.ejemploSimple.services;

import com.example.ejemploSimple.exception.ObjectNotFoundException;
import com.example.ejemploSimple.models.Persona;
import com.example.ejemploSimple.respositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findAllPersonas(){
        return this.personaRepository.findAll();
    }
    @Override
    public Persona findPersona(Long id) throws ObjectNotFoundException {
        Persona persona = this.personaRepository.findById(id).orElse(null);
        if(persona != null){
            return persona;
        }else {
            throw new ObjectNotFoundException("Persona con id " + id + " no se encontro en la bases de datos");
        }
    }

    @Override
    public Persona savePersona(Persona persona){
        return this.personaRepository.save(persona);
    }
    @Override
    public void deletePersona(Long id) throws ObjectNotFoundException {
        Persona persona = this.personaRepository.findById(id).orElse(null);
        if(persona != null){
            this.personaRepository.delete(persona);
        }else {
            throw new ObjectNotFoundException("Persona con id " + id + " no se encontro en la bases de datos");
        }
    }
}
