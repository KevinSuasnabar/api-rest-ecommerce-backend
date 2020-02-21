package com.kev.springboot.backend.tienda.online.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kev.springboot.backend.tienda.online.models.entity.Cliente;
import com.kev.springboot.backend.tienda.online.models.services.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
}
