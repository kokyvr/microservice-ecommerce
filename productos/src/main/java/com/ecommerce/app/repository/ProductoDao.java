package com.ecommerce.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.app.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer>{

	public Optional<Producto> findByName(String name);
	
}
