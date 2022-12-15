package com.cartService.CartService.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import com.cartService.CartService.*;
import com.cartService.CartService.Exception.CustomException;
import com.cartService.CartService.Model.Cart;
import com.cartService.CartService.Model.Drugs;
import com.cartService.CartService.Model.Medicines;
import com.cartService.CartService.Repository.CartRepository;
import com.cartService.CartService.service.CartService;
import com.cartService.CartService.service.CartServiceImpl;
//import com.cartService.CartService.service.CartServiceImpl;


@RestController

//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)

@RequestMapping("/drugs/cart")
public class CartController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartServiceImpl cartServiceImpl;
	@Autowired
	CartService cartService;

	Logger logger=LoggerFactory.getLogger(CartController.class);

	public  CartController(CartService cartService)
	{

		this.cartService=cartService;
	}

    public CartController() {
    }

@GetMapping("/listAll")
public ResponseEntity<List<Cart>> getAllCarts() {
	return ResponseEntity.ok(cartServiceImpl.getallcarts());

}

//add product to cart using productId and cart Id
@PostMapping("/addtocart/{cartId}/{drugId}")
public ResponseEntity<Cart> addDrugToCart( @PathVariable int cartId ,@PathVariable int drugId)  {
Drugs drugs=restTemplate.getForObject("http://Drugs/drugs/"+drugId,Drugs.class);
//String drugs = "http://localhost:5004/drugs/getbyid/{drugsId}";
	logger.info(" "+drugs);
	if(cartRepository.existsById(cartId))
	{
	Cart oldCart=cartRepository.findByCartId(cartId);
	List<Integer> idList = new ArrayList<>();
	List<Medicines> oldMedicine3 =oldCart.getMedicines();

	for(Medicines m : oldMedicine3) {
		idList.add(m.getDrugId());
	}

	 if(idList.contains(drugs.getDrugId())) {
		logger.info("in if method");
		List<Medicines> oldMedicine2= oldCart.getMedicines();


		for (Medicines m : oldMedicine2) {

			if(m.getDrugId()==drugId) {
				m.setDrugsQty(m.getDrugsQty()+1);
			}
		}

		double total =0;

       for (Medicines m : oldMedicine2) {

			total = total+ m.getDrugsCost()*m.getDrugsQty();
		}
		oldCart.setTotal(total);

		return new ResponseEntity<>(cartService.addCart(oldCart),HttpStatus.CREATED);
			}else {


	Medicines medicine= new Medicines();
	 medicine.setDrugId(drugId);
	 medicine.setDrugsName(drugs.getDrugsName());
     medicine.setDrugsCost(drugs.getDrugsCost());
     medicine.setDrugsQty(1);
    // medicine.setStockQty(drugs.getStockQty());
     medicine.setDateOfExpiration(drugs.getDateOfExpiration());
	// medicine.setTotal(drugs.getTotal());

	List<Medicines> oldMedicines =oldCart.getMedicines();
		oldMedicines.add(medicine);
		oldCart.setMedicines(oldMedicines);

		double drugsCost =0;

		for (Medicines m : oldMedicines) {

		drugsCost = drugsCost + m.getDrugsCost()*m.getDrugsQty();
		}
		oldCart.getTotal();

		return new ResponseEntity<>(cartServiceImpl.addCart(oldCart),HttpStatus.CREATED);
	}
	}else {

	Cart cart =  new Cart();
	cart.setCartId(cartId);
	Medicines medicine= new Medicines();
    medicine.setDrugId(drugId);
    medicine.setDrugsName(drugs.getDrugsName());
    medicine.setDrugsCost(drugs.getDrugsCost());
	medicine.setDrugsQty(1);
//	drug.setStockQty(drug.getStockQty());
	medicine.setDateOfExpiration(drugs.getDateOfExpiration());
//	drug.setTotal(drug.getTotal());
	List<Medicines> list= new ArrayList<>();
	list.add(medicine);


	cart.setMedicines(list);
	double drugsCost =0;

	for (Medicines m : list) {

		drugsCost = drugsCost+ m.getDrugsCost()*m.getDrugsQty();
	}
	cart.setTotal(drugsCost);
		return new ResponseEntity<>(cartRepository.save(cart),HttpStatus.CREATED);
	}
}

//get cart by cartId
@GetMapping("/{cartId}")
public ResponseEntity<Cart> getCartById(@PathVariable int cartId) {
	return new ResponseEntity<>(cartService.getCartById(cartId),HttpStatus.OK);

}

//update cart by cartId
@PutMapping("/update/{cartId}")
public ResponseEntity<Cart> updateCart(@PathVariable int cartId ,@Valid @RequestBody Cart cart) throws CustomException {
	return ResponseEntity.ok(cartService.updateCart(cartId, cart));
}

//delete cart by cartId
@DeleteMapping("/delete/{cartId}")
public void deleteCart(@PathVariable int cartId) {
	cartService.deleteCartById(cartId);
}

//remove item from cart using productId and cartId
@PutMapping("/delete/drug/{drugId}/{cartId}")
public Cart deleteCartDrug(@PathVariable int drugsId ,@PathVariable int cartId) throws CustomException {

	Drugs drugs=restTemplate.getForObject("http://Drugs/drugs/"+drugsId,Drugs.class);

	Cart cart2=cartService.getCartById(cartId);
	List<Medicines> list= new ArrayList<>();
	list=cart2.getMedicines();
	System.out.println(list);
	list.removeIf(d->(d.getDrugId()==drugsId));
	cart2.setMedicines(list);
   	double drugsCost =0;
	for (Medicines m : list) {

		drugsCost = drugsCost+ m.getDrugsCost()*m.getDrugsQty();
	}
	cart2.setTotal(drugsCost);

	return 	cartService.updateCart(cart2.getCartId(), cart2);
}

// increase product count in cart using product and cart Id
@PutMapping("/increaseQuant/{drugId}/{cartId}")
public Cart increaseDrug(@PathVariable int drugsId,@PathVariable int cartId) throws CustomException {


	Cart cart =cartService.getCartById(cartId);


	List<Medicines> oldMedicine3 =cart.getMedicines();
			for (Medicines m : oldMedicine3) {

			if(m.getDrugId()==drugsId) {
				m.setDrugsQty(m.getDrugsQty()+1);
			}
		}

		double drugsCost =0;

		for (Medicines m : oldMedicine3) {

			drugsCost = drugsCost+ m.getDrugsCost()*m.getDrugsQty();
		}
		cart.setTotal(drugsCost);

		return cartService.updateCart(drugsId, cart);
}

//decrease item quantity in cart from cartId and  productId
@PutMapping("/decreaseQuant/{drugId}/{cartId}")
public Cart decreaseDrug(@PathVariable int drugsId,@PathVariable int cartId) throws CustomException {
		Cart cart =cartService.getCartById(cartId);
		List<Medicines> oldMedicine3 =cart.getMedicines();
     		for (Medicines m : oldMedicine3) {

			if(m.getDrugId()==drugsId) {
				m.setDrugsQty(m.getDrugsQty()-1);
			}
		}

		double drugsCost =0;

		for (Medicines m : oldMedicine3) {

			drugsCost = drugsCost + m.getDrugsCost()*m.getDrugsQty();
		}
		cart.setTotal(drugsCost);
		return cartService.updateCart(drugsId, cart);

		}
}