package com.ecommerce.biblioteca;

public class BaseRuta {

	public static final String rutaBase;
	public static final String rutaProducto;
	public static final String rutaCategoria;
	
	static {
		rutaBase = "/ecommerce/";
		rutaProducto = rutaBase + "productos/";
		rutaCategoria = rutaBase + "categorias/";
	}
	
	private BaseRuta() {
		// TODO Auto-generated constructor stub
	}
}
