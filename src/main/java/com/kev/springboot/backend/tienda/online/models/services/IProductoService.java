package com.kev.springboot.backend.tienda.online.models.services;

import java.util.List;

import com.kev.springboot.backend.tienda.online.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);
	
	public List<Producto> prodByCategoryId(Long id);
	
	public List<Producto> findProductoByNombre(String term);
	
	public List<Producto> findAvalibleProd();

}
