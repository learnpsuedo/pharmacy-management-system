package com.order.orderservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Order {
	@Id
	private int orderId;

	private int userId;
	private List<Cart> cart;
	private String orderStatus;
	private List<Address> address;
	private double total;


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public List<Cart> getCart() {
		return cart;
	}


	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getOrderStatus() {
		// TODO Auto-generated method stub
		return orderStatus;
	}




}