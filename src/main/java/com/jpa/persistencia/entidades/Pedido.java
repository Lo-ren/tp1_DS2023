package com.jpa.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

public class Pedido extends EntidadBase{

    private String[] estado = {"iniciado", "preparación", "entregado"} ;
    private Date fecha;
    private String tipoEnvio;
    private double total;

    @OneToOne
    @JoinColumn(nullable = true)
    private Factura factura;

}
