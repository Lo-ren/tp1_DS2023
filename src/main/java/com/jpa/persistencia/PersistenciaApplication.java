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
			Producto fideoTallarin = Producto.builder()
					.denominacion("Fideos Tallarines")
					.tipo(Tipo.Manufacturado)
					.precioCompra(400)
					.precioVenta(900)
					.stockMinimo(6)
					.stockActual(75)
					.receta("Fideo Tallarin")
					.tiempoEstimadoCocina(30)
					.unidadMedida("Gramos")
					.build();
			//agregar productos al rubro
			pastas.agregarProducto(raviolesRicota, fideoTallarin);
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
			//Cliente dos
			Cliente clienteDos = Cliente.builder()
					.email("clientedos@email")
					.nombre("Joe")
					.apellido("Mushroom")
					.telefono("987654322")
					.build();
			//Domicilio de cliente dos
			Domicilio domicilioDos = Domicilio.builder()
					.calle("Tucumán")
					.numero("499")
					.localidad("Godoy Cruz")
					.build();
			//Crear Instancia Detalle Pedido
			DetallePedido detalleUno = DetallePedido.builder()
					.cantidad(3)
					.subtotal(6300)
					.build();
			DetallePedido detalleDos = DetallePedido.builder()
					.cantidad(5)
					.subtotal(4500)
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
					.total(6300)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			Pedido pedidoDos = Pedido.builder()
					.fecha(fecha)
					.estado(Estado.Preparacion)
					.total(4500)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			//Crear instancias de factura
			Factura facturaUno = Factura.builder()
					.descuento(300)
					.fecha(fecha)
					.formaPago(FormaPago.TC)
					.numero(222)
					.total(6000)
					.build();
			Factura facturaDos = Factura.builder()
					.descuento(150)
					.fecha(fecha)
					.formaPago(FormaPago.TC)
					.numero(222)
					.total(4350)
					.build();
			//Agregar detalles al pedido
			pedidoUno.agregarDetallePedido(detalleUno);
			pedidoDos.agregarDetallePedido(detalleDos);
			//Vincular detalle pedido con el producto
			detalleUno.setProducto(raviolesRicota);
			detalleDos.setProducto(fideoTallarin);
			//Vincular factura con el pedido
			pedidoUno.setFactura(facturaUno);
			pedidoDos.setFactura(facturaDos);
			//Guardar cliente
			clienteRepository.save(clienteUno);
			clienteRepository.save(clienteDos);

			//Guardar rubro
			rubroRepository.save(pastas);

			//recuperar objeto rubro desde la base de datos
			Rubro rubroRecuperado = rubroRepository.findById(pastas.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominación: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			//recuperar Cliente desde la base de Datos
			Cliente clienteRecuperado1 = clienteRepository.findById(clienteUno.getId()).orElse(null);
			if(clienteRecuperado1 != null){
				System.out.println("Nombre: " + clienteRecuperado1.getNombre());
				System.out.println("Apellido: " + clienteRecuperado1.getApellido());
				System.out.println("Email: " + clienteRecuperado1.getEmail());
				System.out.println("Telefono: " + clienteRecuperado1.getTelefono());
				clienteRecuperado1.mostrarDomicilios();
				clienteRecuperado1.mostrarPedidos();
			}
			Cliente clienteRecuperado2 = clienteRepository.findById(clienteDos.getId()).orElse(null);
			if(clienteRecuperado1 != null){
				System.out.println("Nombre: " + clienteRecuperado2.getNombre());
				System.out.println("Apellido: " + clienteRecuperado2.getApellido());
				System.out.println("Email: " + clienteRecuperado2.getEmail());
				System.out.println("Telefono: " + clienteRecuperado2.getTelefono());
				clienteRecuperado2.mostrarDomicilios();
				clienteRecuperado2.mostrarPedidos();
			}
		};
	}

}
