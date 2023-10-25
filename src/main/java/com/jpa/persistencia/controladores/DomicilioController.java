package com.jpa.persistencia.controladores;

import com.jpa.persistencia.entidades.Domicilio;
import com.jpa.persistencia.servicios.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Creo que esta clase no va
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController extends EntidadBaseControllerImpl<Domicilio, DomicilioServiceImpl>{
}
