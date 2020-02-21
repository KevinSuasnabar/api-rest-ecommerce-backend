package com.kev.springboot.backend.tienda.online.models.services;

import java.util.List;

import com.kev.springboot.backend.tienda.online.models.entity.Cart;

public interface ICartService {

	public List<Cart> getAllCarts();
	
	public Cart save(Cart cart);
	
	public Cart update(Cart cart);
	
}
