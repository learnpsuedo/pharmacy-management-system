package com.order.orderservice.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@NoArgsConstructor

@Document(collection ="cart")
public class Cart {
	  @Id
		private int cartId;
	    private List<Medicines> medicines;
	    //private double total;
		public int getCartId() {
			return cartId;
		}
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		public List<Medicines> getMedicines() {
			return medicines;
		}
		public void setMedicines(List<Medicines> medicines) {
			this.medicines = medicines;
		}
		/*
		 * public double getTotal() { return total; } public void setTotal(double total)
		 * { this.total = total; }
		 */



}