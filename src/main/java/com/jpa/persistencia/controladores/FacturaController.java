package com.jpa.persistencia.controladores;

import com.jpa.persistencia.entidades.Factura;
import com.jpa.persistencia.servicios.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Esta mepa que tampoco se persiste, ver bien
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturas")
public class FacturaController extends EntidadBaseControllerImpl<Factura, FacturaServiceImpl>{
}
