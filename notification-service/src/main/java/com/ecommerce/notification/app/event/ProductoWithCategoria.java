package com.ecommerce.notification.app.event;

import com.ecommerce.biblioteca.dto.Categoria;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoWithCategoria {
	private Integer id;

	private String name;

	private Integer stock;

	private Double price;

	
	private Categoria categoria;
}
