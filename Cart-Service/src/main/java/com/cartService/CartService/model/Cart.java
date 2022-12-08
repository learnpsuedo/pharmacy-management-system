package com.cartService.CartService.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="cart")
public class Cart
{
	private int id;
	private String username;
	private int drugsId;
	private String drugsname;
	private double drugsCost;
	private int drugsQty;
	private int stockQty;
	private String drugsDescription;
	private double total;


	public Cart()
	{

	}

	public Cart(int id, String username, int drugsId, String drugsname, double drugsCost, int drugsQty, int stockQty,
			String drugsDescription, double total) {
		super();
		this.id = id;
		this.username = username;
		this.drugsId = drugsId;
		this.drugsname = drugsname;
		this.drugsCost = drugsCost;
		this.drugsQty = drugsQty;
		this.stockQty = stockQty;
		this.drugsDescription = drugsDescription;
		this.total = total;
	}
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDrugsId() {
		return drugsId;
	}
	public void setDrugsid(int drugsid) {
		this.drugsId = drugsid;
	}
	public String getDrugsname() {
		return drugsname;
	}
	public void setDrugsname(String drugsname) {
		this.drugsname = drugsname;
	}
	public double getDrugsCost() {
		return drugsCost;
	}
	public void setDrugsCost(double drugsCost) {
		this.drugsCost = drugsCost;
	}
	public int getDrugsQty() {
		return drugsQty;
	}
	public void setDrugsQty(int drugsQty) {
		this.drugsQty = drugsQty;
	}
	public int getStockQty() {
		return stockQty;
	}
	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}
	public String getDrugsDescription() {
		return drugsDescription;
	}
	public void setDrugsDescription(String drugsDescription) {
		this.drugsDescription = drugsDescription;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getCartById() {
		// TODO Auto-generated method stub
		return null;
	}




}