package com.ecommerce.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.model.Producto;
import com.ecommerce.app.service.ProductoService;
import com.ecommerce.biblioteca.BaseRuta;


@RestController
@RequestMapping("/ecommerce/productos")
public class ProductoController {

	@Autowired
	private ProductoService service;

	@PostMapping
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {
		try {
			Producto p = service.save(producto);
			return ResponseEntity.created(URI.create(BaseRuta.rutaProducto + p.getId())).body(p);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Integer id) {
		try {
			Producto p = service.update(producto, id);
			if (p != null) {
				return ResponseEntity.created(URI.create(BaseRuta.rutaProducto + p.getId())).body(p);
			}
				return ResponseEntity.notFound().build();
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping
	public ResponseEntity<List<Producto>> findAll() {
		try {
			List<Producto> productos = service.getAll();
			if(!productos.isEmpty()) {
				return ResponseEntity.ok(productos);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getById(@PathVariable Integer id){
		try {
			Producto p = service.getById(id);
			if(p != null) {
				return ResponseEntity.ok(p);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		try {
				service.deleteById(id);
				return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	@GetMapping("/search")
	public ResponseEntity<Producto> getByString(@RequestParam String producto){
		try {
			Producto p = service.getByString(producto);
			if(p != null) {
				return ResponseEntity.ok(p);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

}
