package com.ecommerce.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.app.feign.CategoriaFeign;
import com.ecommerce.app.model.Producto;
import com.ecommerce.app.model.ProductoWithCategoria;
import com.ecommerce.app.repository.ProductoDao;
import com.ecommerce.app.service.ProductoService;
import com.ecommerce.biblioteca.dto.Categoria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private KafkaTemplate<String, ProductoWithCategoria> kafkaTemplate;
	@Autowired
	private ProductoDao dao;

	@Autowired
	private CategoriaFeign feign;

	@Override
	public ProductoWithCategoria save(Producto data) {

		Categoria categoria = feignCategoria(data.getCategoriaId());
		log.info("categoria : {}", categoria);
		if (categoria != null) {
			dao.save(data);
			kafkaTemplate.send("productoCategoriaTopic",builderProductoWithCategoria(data, categoria));
			return builderProductoWithCategoria(data, categoria);
		}
		return null;
	}

	@Override
	public List<ProductoWithCategoria> getAll() {
		// TODO Auto-generated method stub
		List<Producto> p = dao.findAll();
		return p.stream().map(data -> {
			Categoria categoria = feignCategoria(data.getCategoriaId());

			return builderProductoWithCategoria(data, categoria);
		}).collect(Collectors.toList());
	}

	@Override
	public ProductoWithCategoria getById(Integer id) {
		// TODO Auto-generated method stub
		Producto p = dao.findById(id).orElse(null);
		if (p != null) {
			Categoria categoria = feignCategoria(p.getCategoriaId());
			return builderProductoWithCategoria(p, categoria);
		}
		return null;
	}

	@Override
	public ProductoWithCategoria getByString(String text) {
		// TODO Auto-generated method stub
		Producto p = dao.findByName(text).orElse(null);
		if (p != null) {
			Categoria categoria = feignCategoria(p.getCategoriaId());
			return builderProductoWithCategoria(p, categoria);
		}

		return null;
	}

	@Override
	public ProductoWithCategoria update(Producto data, Integer id) {
		// TODO Auto-generated method stub
		ProductoWithCategoria search = getById(id);
		if (search != null) {
			search.setName(data.getName());
			search.setPrice(data.getPrice());
			search.setStock(data.getStock());
			search.getCategoria().setId(data.getCategoriaId());

			Categoria categoria = feignCategoria(search.getCategoria().getId());
			search.getCategoria().setName(categoria.getName());

			Producto p = dao.save(Producto.builder().id(search.getId()).name(search.getName()).stock(search.getStock())
					.price(search.getPrice()).categoriaId(search.getCategoria().getId()).build());

			return ProductoWithCategoria.builder().id(p.getId()).categoria(categoria).name(p.getName())
					.stock(p.getStock()).price(p.getPrice()).build();
		}

		return null;
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);

	}

	private ProductoWithCategoria builderProductoWithCategoria(Producto p, Categoria c) {
		return ProductoWithCategoria.builder().id(p.getId()).categoria(c).name(p.getName()).stock(p.getStock())
				.price(p.getPrice()).build();
	}

	private Categoria feignCategoria(Integer id) {
		return feign.findById(id);
	}

}
