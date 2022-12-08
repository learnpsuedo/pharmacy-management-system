package com.cartService.CartService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartService.CartService.model.Cart;
import com.cartService.CartService.model.Drugs;
import com.cartService.CartService.model.Supplier;
import com.cartService.CartService.service.CartService;
import com.cartService.Exception.CustomException;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/",maxAge = 3600)
@RequestMapping("/cart")
public class CartController {
  @Autowired
  private CartService cartService;


  @PostMapping("/add")
  public ResponseEntity<?> addCart(@RequestBody Cart cart) throws CustomException, Exception {
      return cartService.addUser(cart);
  }


   @GetMapping("/seedrugs")
   public List<Drugs> getAllDetails() {
		return cartService.getAlldetails();
	}

  @GetMapping("/seesupplier")
  public List<Supplier> getAllDetails1() {
	  return cartService.getAllSupplierDetails();
  }


  @GetMapping("/details")
  public List<Cart> getAllCartDetails(){
      return cartService.getAllUsers();
  }

//  Get By Cart Id
  @GetMapping("/{id}")
  public List<Cart> getCartByCartId(@PathVariable("id") int cartid){
      return this.cartService.getCartById(cartid);
  }


// Get by DrugsId
    @GetMapping("/drugs/{id}")
    public List<Cart> getCartById(@PathVariable("id") int id){
      return this.cartService.getCartById(id);
 }

  @GetMapping("/username/{username}")
  public List<Cart> getAllUserName(@PathVariable("username")  String username){
      return this.cartService.getCartByUserName(username);

  }

  @GetMapping("/username/{id}/{username}")
  public Cart getCartByDrugsIdAndUsername(@PathVariable("username")  String username,
          @PathVariable("id") int id){
      return this.cartService.getCartByUserNameAndId(username, id);

  }

 @PutMapping("/username/{id}/{username}")
  public Cart updateCartByDrugsQty(@RequestBody Cart cart, @PathVariable("id") int id) {
      return this.cartService.updateCartQty(cart);

  }

  @PutMapping("/{Id}")
  public Cart updateCartQty(@RequestBody Cart cart, @PathVariable("Id") int Id) {
      return this.cartService.updateCartQty(cart);

  }

  @DeleteMapping("/{username}")
  public String deleteCarts(@PathVariable("username") String username) {
      return this.cartService.deleteCartsByUsername(username);
  }
}