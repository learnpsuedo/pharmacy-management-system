package com.cartService.CartService.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cartService.CartService.Model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,Integer>{


Cart findByCartId(int cartId);

boolean existsById(int cartId);

void deleteById(int cartId);

}
