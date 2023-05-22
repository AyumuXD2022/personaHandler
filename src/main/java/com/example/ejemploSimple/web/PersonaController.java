package com.example.ejemploSimple.web;

import com.example.ejemploSimple.exception.ObjectNotFoundException;
import com.example.ejemploSimple.models.Persona;
import com.example.ejemploSimple.services.IPersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> findAllPersonas(){
        return ResponseEntity.ok(this.personaService.findAllPersonas());
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<?> findPersona(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok(this.personaService.findPersona(id));
    }

    @PostMapping("/persona")
    public ResponseEntity<?> savePersona(@RequestBody @Valid Persona persona) {
        Map<String, Object> response = new HashMap<>();
        Persona personaNew = this.personaService.savePersona(persona);

        response.put("mensaje","Se ha aguardado");
        response.put("persona", personaNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody @Valid Persona persona, @PathVariable Long id) throws ObjectNotFoundException {
        Map<String, Object> response = new HashMap<>();
        Persona personaActual = this.personaService.findPersona(id);

        persona.setId(personaActual.getId());
        personaActual = persona;

        Persona personaUpdate = this.personaService.savePersona(personaActual);

        response.put("mensaje","Se ha actualizado");
        response.put("persona", personaUpdate);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @DeleteMapping("/persona/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id) throws ObjectNotFoundException {
        Map<String, Object> response = new HashMap<>();
        this.personaService.deletePersona(id);
        response.put("mensaje","Se ha eliminado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
