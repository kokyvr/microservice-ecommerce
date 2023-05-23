package com.ecommerce.biblioteca;

import java.util.List;

public interface ICrud<T> {
	
	public T save(T data);
	
	public List<T> getAll();
	
	public T getById(Integer id);
	
	public T getByString(String text);
	
	public T update(T data,Integer id);
	
	public void deleteById(Integer id);
	
}
