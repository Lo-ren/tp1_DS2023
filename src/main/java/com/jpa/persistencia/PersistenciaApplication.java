package com.jpa.persistencia;

import com.jpa.persistencia.entidades.*;
import com.jpa.persistencia.enumeraciones.Estado;
import com.jpa.persistencia.enumeraciones.FormaPago;
import com.jpa.persistencia.enumeraciones.Tipo;
import com.jpa.persistencia.enumeraciones.TipoEnvio;
import com.jpa.persistencia.repositorios.ClienteRepository;
import com.jpa.persistencia.repositorios.RubroRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@Builder

public class PersistenciaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaApplication.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1){
		return args -> {
			System.out.println("----------------ESTOY FUNCIONANDO---------------------");
			//crear instancia rubro
			Rubro pastas = Rubro.builder()
					.denominacion("Pastas")
					.build();
			//crear instancias de productos
			Producto raviolesRicota = Producto.builder()
					.denominacion("Ravioles de ricota")
					.tipo(Tipo.Manufacturado)
					.precioCompra(700)
					.precioVenta(1500)
					.stockMinimo(3)
					.stockActual(65)
					.receta("Ravioles ricota")
					.tiempoEstimadoCocina(35)
					.unidadMedida("Plancha")
					.build();
			//agregar productos al rubro
			pastas.agregarProducto(raviolesRicota);
			//Crear instancia cliente
			Cliente clienteUno = Cliente.builder()
					.email("clienteuno@email")
					.nombre("Pepito")
					.apellido("Honguito")
					.telefono("987654321")
					.build();
			//Crear instancia domicilio
			Domicilio domicilioUno = Domicilio.builder()
					.calle("Beltran")
					.numero("2025")
					.localidad("Godoy Cruz")
					.build();
			//agregar domicilios a cliente
			clienteUno.agregarDomicilio(domicilioUno);
			//Crear Instancia Detalle Pedido
			DetallePedido detalleUno = DetallePedido.builder()
					.cantidad(3)
					.subtotal(6300)
					.build();
			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-09";
			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);
			//Crear Instancia Pedido
			Pedido pedidoUno = Pedido.builder()
					.fecha(fecha)
					.estado(Estado.Preparacion)
					.total(4500)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			//Crear instancias de factura
			Factura facturaUno = Factura.builder()
					.descuento(200)
					.fecha(fecha)
					.formaPago(FormaPago.TC)
					.numero(222)
					.total(4300)
					.build();
			//Agregar detalles al pedido
			pedidoUno.agregarDetallePedido(detalleUno);
			//Vincular detalle pedido con el producto
			detalleUno.setProducto(raviolesRicota);
			//Vincular factura con el pedido
			pedidoUno.setFactura(facturaUno);
			//guardar cliente
			clienteRepository.save(clienteUno);

			rubroRepository.save(pastas);

			//recuperar objeto rubro desde la base de datos
			Rubro rubroRecuperado = rubroRepository.findById(pastas.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominación: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			//recuperar Cliente desde la base de Datos
			Cliente clienteRecuperado = clienteRepository.findById(clienteUno.getId()).orElse(null);
			if(clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();
			}
		};
	}

}
