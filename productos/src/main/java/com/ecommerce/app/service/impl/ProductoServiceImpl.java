package com.ecommerce.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.feign.CategoriaFeign;
import com.ecommerce.app.model.Producto;
import com.ecommerce.app.repository.ProductoDao;
import com.ecommerce.app.service.ProductoService;
import com.ecommerce.biblioteca.dto.Categoria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoDao dao;
	
	@Autowired
	private CategoriaFeign feign;
	
	
	@Override
	public Producto save(Producto data) {
		
		Categoria categoria = feign.findById(data.getCategoriaId());
		log.info("categoria : {}",categoria);
		if(categoria !=null) {
			return dao.save(data);
		}
		return null;
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Producto getById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public Producto getByString(String text) {
		// TODO Auto-generated method stub
		return dao.findByName(text).orElse(null);
	}

	@Override
	public Producto update(Producto data, Integer id) {
		// TODO Auto-generated method stub
		Producto search = getById(id);
		if(search != null) {
			search.setName(data.getName());
			search.setPrice(data.getPrice());
			search.setStock(data.getStock());
			
			dao.save(search);
			return search;
		}
		
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

}
