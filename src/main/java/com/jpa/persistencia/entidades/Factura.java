package com.jpa.persistencia.entidades;

import com.jpa.persistencia.enumeraciones.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "factura")

public class Factura extends EntidadBase {

    private int numero;
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;
}
