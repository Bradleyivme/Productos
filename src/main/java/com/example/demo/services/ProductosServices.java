package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.example.demo.entites.Productos;

@Service
public class ProductosServices implements InterProductosServices{
	
	private static AtomicLong sequence = new AtomicLong();
	private static List<Productos> lista = new ArrayList<Productos>() {{
		add(new Productos(sequence.incrementAndGet(),"audifonos","sony","bluetooth","100"));
		add(new Productos(sequence.incrementAndGet(),"cargador","apple","inalámbrico","300"));
		add(new Productos(sequence.incrementAndGet(),"estuche","apple","protector","150"));
	}};
	
	public List<Productos> listarProductos(){
		return lista;
	}

	@Override
	public Productos buscarProductos(long id) {
		for (Productos e: lista) {
			if (e.getId().equals(id))
				return e;
		}
		return null;
	}

	@Override
	public void crearProductos(Productos productos) {
		productos.setId(sequence.incrementAndGet());
		lista.add(productos);
		
	}
	
	@Override
	public Productos actualizarProductos(Productos productos){
		
		for(Productos x : lista) {
			
			if(x.getId() == productos.getId()) {
				x.setNombre(productos.getNombre());
				x.setMarca(productos.getMarca());
				x.setDescripcion(productos.getDescripcion());
				x.setPrecio(productos.getPrecio());
				return x;
			}
		} return null;
		
	}
	
	@Override
	public void eliminarProductos(long id) {	
			
		for(Productos x : lista) {
			if(x.getId() == id) {
				lista.remove(x);
			}
		}
		
	}

}
