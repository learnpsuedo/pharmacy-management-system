package com.cartService.CartService.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import com.cartService.CartService.Model.Cart;
import com.cartService.CartService.Repository.CartRepository;



@Service
public class CartServiceImpl implements CartService {

	Logger logger= LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	private CartRepository cartRepository;


	@Override
	public Cart getCartById(int cartId)
	{

		return cartRepository.findByCartId(cartId);
	}

	@Override
	public Cart updateCart1(int cartId,Cart cart) {

		Cart updatedCart= cartRepository.findByCartId(cartId);

		updatedCart.setCartId( cart.getCartId());
		updatedCart.setMedicines( cart.getMedicines());
		updatedCart.setTotal( cart.getTotal());

		cartRepository.save(updatedCart);

		return updatedCart;

	}

	@Override
	public List<Cart> getallcarts() {

		return cartRepository.findAll();
	}

	@Override
	public double cartTotal(Cart cart) {

		return cart.getTotal();
	}

	@Override
	public Cart addCart(Cart cart){

		return cartRepository.save(cart);
	}



	@Override
	public void deleteCartById(int cartId) {
		cartRepository.deleteById(cartId);

	}


	@Override
	public Cart updateCart(int cartId, Cart cart2) {
		// TODO Auto-generated method stub
		return updateCart(cartId,cart2);
	}





}