package com.ecommerce.biblioteca;

import java.util.List;

public interface ICrudGenericTwoArguments<T,K> {
	public T save(K data);
	
	public List<T> getAll();
	
	public T getById(Integer id);
	
	public T getByString(String text);
	
	public T update(K data,Integer id);
	
	public void deleteById(Integer id);
}
