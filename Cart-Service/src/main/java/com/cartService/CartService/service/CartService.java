package com.cartService.CartService.service;


import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartService.CartService.cartrepository.CartRepository;
import com.cartService.CartService.model.Cart;
import com.cartService.CartService.model.Drugs;
import com.cartService.CartService.model.MessageResponse;
import com.cartService.CartService.model.Supplier;
import com.cartService.Exception.CustomException;



       @Service
       public class CartService {



      @Autowired
      private CartRepository cartRepository;


      @Autowired
      private RestTemplate restTemplate;


      String url1 = "http://Drugs/drugs" ;

      public List<Drugs> getAlldetails()
      {
      	Drugs[] drugs=restTemplate.getForObject(url1+"/list",Drugs[].class);
      	return (Arrays.asList(drugs));
      }


      String url2 = "http://supplier-microservice/supplier";

      public List<Supplier> getAllSupplierDetails()
      {
    	  Supplier[] suppliers=restTemplate.getForObject(url2+"/list",Supplier[].class);
    	  return (Arrays.asList(suppliers));

      }

      private static final Logger
      LOGGER=LoggerFactory.getLogger(CartService.class);

      public ResponseEntity<?> addUser(Cart cart) throws CustomException, Exception
      {
          Cart cart1 = new Cart();
         if(cartRepository.existsByUsernameAndId(cart.getId(),cart.getUsername()))
         {
             LOGGER.error(null);
             return ResponseEntity.badRequest().body(new MessageResponse("Error: The DrugsId has already been taken in the Cart"));
             }
         else
         {
             LOGGER.info("Sucessfully Registered new Cart");
             cart.setTotal(cart.getDrugsCost()* 1); cart1 = cartRepository.save(cart);
         }

         return ResponseEntity.ok(cart1);
      }

      public List<Cart> getAllUsers()
      {
            return cartRepository.findAll();
      }



      public List<Cart> getCartByUserName(String username)
      {
            return  cartRepository.findByUsername(username);
      }



      public Cart updateCartQty(Cart carts)
      {
      carts.setTotal(carts.getDrugsQty()*carts.getDrugsCost());
      return cartRepository.save(carts);
      }

      public List<Cart> getById(int id)
      {
        return cartRepository.findById(id);
      }



      public List<Cart> getCartById(int Id)
      {
        return cartRepository.findById(Id);
      }



      public Cart getCartByUserNameAndId(String username, int id)
      {
            return  cartRepository.findByUsernameAndId(id, username);
      }
      public String deleteCartsByUsername(String username)
      {
        cartRepository.deleteByUsername(username);
        return "Deleted Successfully";
      }

	public Cart addNewCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}


      }













