package com.ecommerce.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.biblioteca.dto.Categoria;

@FeignClient("categoria-service")
public interface CategoriaFeign {
	
	@GetMapping("/ecommerce/categorias/{id}")
	public Categoria findById(@PathVariable(value = "id") Integer id);
	
}
