package com.kev.springboot.backend.tienda.online.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.kev.springboot.backend.tienda.online.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
