package com.kev.springboot.backend.tienda.online.models.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "cart_items")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	private Integer cantidad;

	public CartItem() {
		super();
	}

	public CartItem(Cart cart, Producto producto, Integer cantidad) {
		this.cart = cart;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Double getTotalPrice() {
		return getProducto().getPrecio()*getCantidad();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnoreProperties({"items","hibernateLazyInitializer","handler"})
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@JsonIgnoreProperties({"producto","hibernateLazyInitializer","handler"})
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
