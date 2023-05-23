package com.ecommerce.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.app.model.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Integer>{

	Optional<Categoria> findByName(String name);
}
