package com.jpa.persistencia.controladores;

import com.jpa.persistencia.entidades.Rubro;
import com.jpa.persistencia.servicios.RubroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubros")
public class RubroController extends EntidadBaseControllerImpl<Rubro, RubroServiceImpl>{
}
