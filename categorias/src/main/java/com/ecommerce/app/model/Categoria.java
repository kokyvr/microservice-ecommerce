package com.ecommerce.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
	
	@SequenceGenerator(name = "categoria_id_sequence", sequenceName = "categoria_id_sequence")
	@GeneratedValue(generator = "categoria_id_sequence")
	@Id
	private Integer id;
	
	private String name;
}
