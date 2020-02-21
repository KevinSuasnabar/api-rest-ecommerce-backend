package com.kev.springboot.backend.tienda.online.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kev.springboot.backend.tienda.online.models.entity.Cart;
import com.kev.springboot.backend.tienda.online.models.entity.CartItem;
import com.kev.springboot.backend.tienda.online.models.services.ICartItemService;
import com.kev.springboot.backend.tienda.online.models.services.ICartService;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ICartItemService cartItemService;

	@GetMapping("/carts")
	public List<Cart> getAll() {
		return cartService.getAllCarts();
	}

	@PostMapping("/carts")
	public ResponseEntity<?> create(@RequestBody Cart cart, BindingResult result) {
		Cart newCart = new Cart();
		
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()// guardamos los errores en esa lista
					.stream().map(err -> {
						return "'El campo " + err.getField() + "' " + err.getDefaultMessage();
					}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);// error 400

		}

		try {
			newCart = cartService.save(cart);
			
			List<CartItem> cartItems=cart.getItems();
			for(int i=0;i<cartItems.size();i++) {
				CartItem ci=cartItemService.create(new CartItem(cart,cartItems.get(i).getProducto(),cartItems.get(i).getCantidad()));
				//System.out.println(ci.getId());
			}
			
			
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cart creado con exito!");
		response.put("cart", newCart);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
