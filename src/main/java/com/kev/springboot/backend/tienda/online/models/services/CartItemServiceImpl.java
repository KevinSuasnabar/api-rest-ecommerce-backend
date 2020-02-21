package com.kev.springboot.backend.tienda.online.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kev.springboot.backend.tienda.online.models.dao.ICartITemDao;
import com.kev.springboot.backend.tienda.online.models.entity.CartItem;

@Service
public class CartItemServiceImpl implements ICartItemService{
	
	@Autowired
	private ICartITemDao cartItemDao;

	@Override
	public CartItem create(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemDao.save(cartItem);
	}

}
