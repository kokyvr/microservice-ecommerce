package com.ecommerce.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@SequenceGenerator(name = "producto_id_sequence", sequenceName = "producto_id_sequence")
	@GeneratedValue(generator = "producto_id_sequence")
	@Id
	private Integer id;

	private String name;

	private Integer stock;

	private Double price;

	private Integer categoriaId;
	
}
