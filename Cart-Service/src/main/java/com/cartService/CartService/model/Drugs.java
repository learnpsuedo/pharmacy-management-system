package com.cartService.CartService.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="drugs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drugs {

	@Transient
	public static final String SEQUENCE_NAME = "drugs_sequence";

	@Id
	private int drugsId;
	private String drugsName;
	private double drugsCost;
	private int stockQty;
	private String categories;
	private String drugsDescription;
	private String supplierName;
	private Date dateOfExpiration;



	public int getDrugsId() {
		return drugsId;
	}

	public void setDrugsId(int id) {
		this.drugsId = id;
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

	public Date getDateOfExpiration() {
		return dateOfExpiration;
	}

	public void setDateOfExpiration(Date dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}





}