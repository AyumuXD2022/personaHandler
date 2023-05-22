package com.example.ejemploSimple.respositories;

import com.example.ejemploSimple.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
