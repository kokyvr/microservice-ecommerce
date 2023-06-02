package com.ecommerce.notification.app.event;

import com.ecommerce.biblioteca.dto.Categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoWithCategoria {
	private Integer id;

	private String name;

	private Integer stock;

	private Double price;

	
	private Categoria categoria;
}
