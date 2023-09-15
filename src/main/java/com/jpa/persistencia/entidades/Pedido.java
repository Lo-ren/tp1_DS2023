package com.jpa.persistencia.entidades;

import com.jpa.persistencia.enumeraciones.Estado;
import com.jpa.persistencia.enumeraciones.TipoEnvio;
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

    private Estado estado;
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private double total;

    @OneToOne
    @JoinColumn(nullable = true, name = "Factura-id")
    private Factura factura;

    @OneToMany
    @JoinColumn(name = "Pedido-id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePedidoed){

        detallePedidos.add(detallePedidoed);
    }

}
