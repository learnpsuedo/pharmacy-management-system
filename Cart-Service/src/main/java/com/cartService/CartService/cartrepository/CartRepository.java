package com.cartService.CartService.cartrepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cartService.CartService.model.Cart;

@Repository public interface CartRepository extends MongoRepository<Cart,String>{


//List<Cart> findAll(int id, String username, int drugsId, String drugsName, double drugsCost, int drugsQty, int stockQty, String drugsDescription, double total );

List<Cart> findByUsername(String username);

List<Cart> findByDrugsId(int drugsId);

List<Cart> findById(int cartId);

Cart findByUsernameAndId(int drugsId, String username);

Boolean existsByUsernameAndId(int drugsId, String username);

void deleteByUsername(String username);
}

