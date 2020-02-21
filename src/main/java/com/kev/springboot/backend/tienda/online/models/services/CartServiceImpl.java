package com.kev.springboot.backend.tienda.online.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.kev.springboot.backend.tienda.online.models.dao.ICartDao;
import com.kev.springboot.backend.tienda.online.models.entity.Cart;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private ICartDao cartDao;

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return (List<Cart>) cartDao.findAll();
	}

	@Override
	public Cart save(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.save(cart);
	}

	@Override
	public Cart update(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.save(cart);
	}
	
	
	
	
}
