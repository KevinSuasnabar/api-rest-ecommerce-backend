package com.kev.springboot.backend.tienda.online.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kev.springboot.backend.tienda.online.models.dao.ICategoriaDao;
import com.kev.springboot.backend.tienda.online.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(id).orElse(null);
	}

	@Override
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDao.save(categoria);
	}

	@Override
	public void delete(Long id) {
		categoriaDao.deleteById(id);
		
	}

	@Override
	public Categoria cateByIdWhitProd(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.cateByIdWhitProd(id);
	}

}
