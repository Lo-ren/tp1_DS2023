package com.jpa.persistencia.controladores;

import com.jpa.persistencia.entidades.Producto;
import com.jpa.persistencia.servicios.ProductoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos")
public class ProductoController extends EntidadBaseControllerImpl<Producto, ProductoServiceImpl>{
}
