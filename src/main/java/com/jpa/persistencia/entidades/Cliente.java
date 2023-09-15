package com.jpa.persistencia.entidades;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "cliente-id")

    @Builder.Default

    private List<Domicilio> domicilios = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "cliente-id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();


    public void agregarDomicilio(Domicilio domi){

        domicilios.add(domi);
    }

    public void agregarPedido(Pedido ped){

        pedidos.add(ped);
    }


    public void mostrarDomicilios() {
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println("Calle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero());
        }
    }

    public void mostrarPedidos() {
        System.out.println("Pedidos de " + nombre + " " + apellido + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha() + ", Total: " + pedido.getTotal());
            int counter = 0;
            for (DetallePedido detalle: pedido.getDetallePedidos()){
                counter += 1;
                System.out.println("Producto "+counter+": "+detalle.getProducto().getDenominacion()+"  cantidad: "+detalle.getCantidad()+"  subtotal: "+detalle.getSubtotal());
            }
        }
    }

}
