package com.jpa.persistencia.entidades;

import com.jpa.persistencia.enumeraciones.TipoProducto;
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

public class Producto extends EntidadBase {

    private TipoProducto tipoProducto;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioCompra;
    private double precioVenta;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;

}
