package com.kev.springboot.backend.tienda.online.models.services;

import com.kev.springboot.backend.tienda.online.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);

}
