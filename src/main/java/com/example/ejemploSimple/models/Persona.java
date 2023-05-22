package com.example.ejemploSimple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "personas")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Nombre no puede estar vacia")
    @Pattern(regexp = "[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*", message = "Escribe bien tu nombre")
    private String nombre;

    @Pattern(regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
            ,message = "Escribe bien tu correo")
    @NotEmpty(message = "Email no puede estar vacia")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "0{0,2}([\\+]?[\\d]{1,3} ?)?([\\(]([\\d]{2,3})[)] ?)?[0-9][0-9 \\-]{6,}( ?([xX]|([eE]xt[\\.]?)) ?([\\d]{1,5}))?"
            ,message = "Escribe bien tu telefono")
    @NotEmpty(message = "Telefono no puede estar vacia")
    private String telefono;


}
