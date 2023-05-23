package com.ecommerce.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductoDto {
	private Integer id;

	private String name;

	private Integer stock;

	private Double price;
}
