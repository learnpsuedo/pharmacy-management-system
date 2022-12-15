package com.cartService.CartService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cartService.CartService.Model.Cart;

@Service
public interface CartService  {



	public List<Cart> getallcarts();

	public double cartTotal(Cart cart);

	public Cart addCart(Cart cart);
	public void deleteCartById(int cartId);

	public Cart getCartById(int cartId);


	public Cart updateCart(int drugId, Cart cart);

	Cart updateCart1(int cartId, Cart cart);




}