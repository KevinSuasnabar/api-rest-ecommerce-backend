package com.kev.springboot.backend.tienda.online.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kev.springboot.backend.tienda.online.models.entity.Categoria;
import com.kev.springboot.backend.tienda.online.models.entity.Producto;

public interface ICategoriaDao extends CrudRepository<Categoria, Long>{

	@Query(nativeQuery = true,value = "SELECT * FROM categorias INNER JOIN prod_cate ON categorias.id = prod_cate.fk_categoria inner join productos on prod_cate.fk_producto=productos.id where categorias.id=?1")
	public Categoria cateByIdWhitProd(Long id);
	
}
