package com.jpa.persistencia.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto extends EntidadBase {

    private String[] tipo = {"manufacturado", "insumo"};
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;


}
