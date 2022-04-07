package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entites.Productos;
import com.example.demo.services.InterProductosServices;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	InterProductosServices productosServices;
	
	
	@GetMapping()
	public List<Productos> listarProductos(){
		List<Productos> lista = productosServices.listarProductos();
		return lista;
	}
	
	@GetMapping("/{id}")
	public Productos buscarProductos(@PathVariable Long id) {
		Productos productos = productosServices.buscarProductos(id);
		return productos;
	}
	
	@PostMapping
	public String crearProductos(@RequestBody Productos productos) {
		String mensaje = "Dato creado";
		productosServices.crearProductos(productos);
		return mensaje;
	}
	
	@PutMapping
	public Productos actualizarProductos(@RequestBody Productos productos) {
		Productos x = productosServices.actualizarProductos(productos);
		return x;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarProductos(@PathVariable Long id) {
		String mensaje = "Eliminado";
		productosServices.eliminarProductos(id);
		return mensaje;
	}

	
}
