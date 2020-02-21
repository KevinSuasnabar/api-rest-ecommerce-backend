package com.kev.springboot.backend.tienda.online.models.services;

import java.util.List;

import com.kev.springboot.backend.tienda.online.models.entity.Cliente;

public interface IClienteService {

	public Cliente create(Cliente cliente);
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public void delete(Long id);
}
