package com.jpa.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido extends EntidadBase{

    private String[] estado = {"iniciado", "preparación", "entregado"} ;
    private Date fecha;
    private String[] tipoEnvio = {"delivery", "retira"};
    private double total;

    @OneToOne
    @JoinColumn(nullable = true, name = "idFactura")
    private Factura factura;

    @OneToMany
    @JoinColumn(name = "Pedido-id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePedidoed){

        detallePedidos.add(detallePedidoed);
    }

}
