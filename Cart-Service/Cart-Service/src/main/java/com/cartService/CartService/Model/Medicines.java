package com.cartService.CartService.Model;



import java.time.LocalDate;


public class Medicines {

	private int drugId;
	private String drugsName;
	private double drugsCost;
	private int drugsQty;
	private LocalDate dateOfExpiration;
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getDrugsName() {
		return drugsName;
	}
	public void setDrugsName(String drugsName) {
		this.drugsName = drugsName;
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
	public LocalDate getDateOfExpiration() {
		return dateOfExpiration;
	}
	public void setDateOfExpiration(LocalDate dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}




}
