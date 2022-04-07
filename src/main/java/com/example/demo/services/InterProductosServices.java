package com.example.demo.services;

import java.util.List;
import com.example.demo.entites.Productos;

public interface InterProductosServices{
	
	public List<Productos> listarProductos();
	public Productos buscarProductos(long id);
	public void crearProductos(Productos productos);
	public Productos actualizarProductos(Productos productos);
	public void eliminarProductos(long id);
	
}
