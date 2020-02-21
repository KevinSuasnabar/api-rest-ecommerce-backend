package com.kev.springboot.backend.tienda.online.models.services;

import java.util.List;

import com.kev.springboot.backend.tienda.online.models.entity.Categoria;

public interface ICategoriaService {

	public List<Categoria> getAll();
	
	public Categoria findById(Long id);
	
	public Categoria save(Categoria categoria);
	
	public void delete(Long id);
	
	public Categoria cateByIdWhitProd(Long id);
}

