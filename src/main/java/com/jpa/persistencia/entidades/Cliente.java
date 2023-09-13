package com.jpa.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente extends EntidadBase {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;


}
