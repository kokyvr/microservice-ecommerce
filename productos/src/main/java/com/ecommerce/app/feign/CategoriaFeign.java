package com.ecommerce.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.biblioteca.dto.Categoria;

@FeignClient(name = "categoria-service",url = "http://localhost:8081/ecommerce/categorias")
public interface CategoriaFeign {
	
	@GetMapping("/{id}")
	public Categoria findById(@PathVariable(value = "id") Integer id);
	
}
