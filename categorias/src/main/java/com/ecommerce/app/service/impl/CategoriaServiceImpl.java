package com.ecommerce.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.model.Categoria;
import com.ecommerce.app.repository.CategoriaDao;
import com.ecommerce.app.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDao dao;
	
	@Override
	public Categoria save(Categoria data) {
		// TODO Auto-generated method stub
		return dao.save(data);
	}

	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Categoria getById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public Categoria getByString(String text) {
		// TODO Auto-generated method stub
		return dao.findByName(text).orElse(null);
	}

	@Override
	public Categoria update(Categoria data, Integer id) {
		Categoria categoria = getById(id);
		if(categoria != null) {
			categoria.setName(data.getName());
			
			dao.save(categoria);
			
			return categoria;
		}
		
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
