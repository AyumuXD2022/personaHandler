package com.example.ejemploSimple.services;

import com.example.ejemploSimple.exception.ObjectNotFoundException;
import com.example.ejemploSimple.models.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> findAllPersonas();

    Persona findPersona(Long id) throws ObjectNotFoundException;

    Persona savePersona(Persona persona);

    void deletePersona(Long id) throws ObjectNotFoundException;
}
