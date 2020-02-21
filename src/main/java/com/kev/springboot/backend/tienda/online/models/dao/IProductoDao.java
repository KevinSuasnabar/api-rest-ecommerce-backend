package com.kev.springboot.backend.tienda.online.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kev.springboot.backend.tienda.online.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

	@Query(nativeQuery = true,value = "SELECT * FROM productos INNER JOIN prod_cate ON productos.id = prod_cate.fk_producto where prod_cate.fk_categoria=?1")
	public List<Producto> prodByCategoryId(Long id);
}
