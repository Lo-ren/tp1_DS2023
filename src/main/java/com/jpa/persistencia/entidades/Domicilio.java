package com.jpa.persistencia.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Domicilio extends EntidadBase {

    private String calle;
    private String numero;
    private String localidad;

}
