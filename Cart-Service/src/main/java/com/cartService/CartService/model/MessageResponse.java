package com.cartService.CartService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponse {
	
	private String message;

	public MessageResponse(String message) {
		super();
		this.message = message;
	}
	

}