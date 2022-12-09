package com.order.orderservice.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicines {

	private int drugsId;
	private String drugsName;
	private double drugsCost;
	private int drugsQty;
	private LocalDate dateOfExpiration;
	public int getDrugsId() {
		return drugsId;
	}
	public void setDrugsId(int drugsId) {
		this.drugsId = drugsId;
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
