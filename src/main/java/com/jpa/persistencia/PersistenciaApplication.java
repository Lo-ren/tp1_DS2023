package com.jpa.persistencia;

import com.jpa.persistencia.entidades.Domicilio;
import com.jpa.persistencia.entidades.Cliente;
import com.jpa.persistencia.repositorios.ClienteRepository;
import com.jpa.persistencia.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication


public class PersistenciaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaApplication.class, args);
		System.out.println("Estoy funcionando con bidireccionaliidad");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, DomicilioRepository domicilioRepository){
		return args -> {
			System.out.println("----------Estoy funcionando---------");
		//Método builder

			Domicilio domicilio = Domicilio.builder()
					.calle("Suipacha")
					.numero(30)
					.localidad("Godoy Cruz")
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Juan")
					.apellido("Perez")
					.telefono("123456789")
					.email("juancito@email")
					.build();

			domicilio.setCliente(cliente);
			cliente.setDomicilio(domicilio);
			// Guardar el objeto Persona en la base de datos
			clienteRepository.save(cliente);
			// Recuperar el objeto Persona desde la base de datos
			CLiente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);

			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre()); System.out.println("Apellido: " +
						clienteRecuperado.getApellido());
				System.out.println("Edad: " + clienteRecuperado.getEdad()); System.out.println("Calle : " +
						clienteRecuperado.getDomicilio().getCalle()); System.out.println("Número :" +
						clienteRecuperado.getDomicilio().getNumero()); }
			System.out.println("...... Muestro la bidireccionalidad......."); // Recuperar el objeto Persona desde la base de datos
			Domicilio domicilioRecuperado =
					domicilioRepository.findById(persona.getId()).orElse(null); if (domicilioRecuperado!= null) {
				System.out.println("Nombre: " + domicilioRecuperado.getPersona().getNombre());
				System.out.println("Apellido: " + domicilioRecuperado.getPersona().getApellido());
				System.out.println("Edad: " + domicilioRecuperado.getPersona().getEdad());
				System.out.println("Calle : " + domicilioRecuperado.getCalle());
				System.out.println("Número :" + domicilioRecuperado.getNumero());
			}
		};
	}

}
