package com.jpa.persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetallePedido extends EntidadBase {

    private int cantidad;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "FKproducto")
    private Producto producto;

}
