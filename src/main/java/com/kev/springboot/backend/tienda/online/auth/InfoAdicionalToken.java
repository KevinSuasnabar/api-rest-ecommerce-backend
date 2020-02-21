package com.kev.springboot.backend.tienda.online.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.kev.springboot.backend.tienda.online.models.entity.Usuario;
import com.kev.springboot.backend.tienda.online.models.services.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private IUsuarioService usuarioService;
	
	//para agregar informacion adicional a nuestro token
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario=usuarioService.findByUsername(authentication.getName());
		Map<String,Object> info=new HashMap<>();
		info.put("info adicional", "Hola que tal ".concat(authentication.getName()));
		
		info.put("nombre", usuario.getNombre());

		info.put("apellido", usuario.getApellido());

		info.put("email", usuario.getEmail());

		//usamos la clase concreta para poder invocar uss metodos
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
