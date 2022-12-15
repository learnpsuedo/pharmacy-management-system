package com.cartService.CartService.Model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="drugs")

public class Drugs {


	 @Transient
	 public static final String SEQUENCE_NAME = "drugs_sequence";


	@Id
	private int drugId;
	private String drugsName;
	private double drugsCost;
	private int stockQty;
	private String categories;
	private String drugsDescription;
	private String supplierName;
	private LocalDate dateOfExpiration;
	private int drugsQty;
	private double total;



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
	public int getStockQty() {
		return stockQty;
	}
	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getDrugsDescription() {
		return drugsDescription;
	}
	public void setDrugsDescription(String drugsDescription) {
		this.drugsDescription = drugsDescription;
	}
	public String getSupplierName() {
		return supplierName;
	}
    public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public LocalDate getDateOfExpiration() {
		return dateOfExpiration;
	}
	public void setDateOfExpiration(LocalDate dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}
	public int getDrugsQty() {
		return drugsQty;
	}
	public void setDrugsQty(int drugsQty) {
		this.drugsQty = drugsQty;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}



	public static String getSequenceName() {
		return SEQUENCE_NAME;
		}





}