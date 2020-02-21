package com.kev.springboot.backend.tienda.online.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kev.springboot.backend.tienda.online.models.entity.Usuario;

public interface IUserDao extends CrudRepository<Usuario, Long>{

	
	//forma 1
	public Usuario findByUsername(String username);
	
	
	//forma con query JPQL
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);
}
