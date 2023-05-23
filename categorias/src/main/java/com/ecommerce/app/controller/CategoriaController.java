package com.ecommerce.app.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.model.Categoria;
import com.ecommerce.app.service.CategoriaService;
import com.ecommerce.biblioteca.BaseRuta;

@RestController
@RequestMapping("/ecommerce/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		try {
			Categoria cate = service.save(categoria);
			return ResponseEntity.created(URI.create(BaseRuta.rutaCategoria + cate.getId())).body(cate);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria,@PathVariable Integer id){
		try {
			Categoria cate = service.update(categoria, id);
			if(cate != null) {
				return ResponseEntity.created(URI.create(BaseRuta.rutaCategoria + cate.getId())).body(cate);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Integer id){
		try {
			Categoria categoria = service.getById(id);
			if(categoria != null) {
				return ResponseEntity.ok(categoria);
			}
			return ResponseEntity.notFound().build();
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	@GetMapping("/search")
	public ResponseEntity<Categoria> getByString(@RequestParam String name){
		try {
			Categoria cate = service.getByString(name);
			if(cate !=null) {
				return ResponseEntity.ok(cate);	
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
