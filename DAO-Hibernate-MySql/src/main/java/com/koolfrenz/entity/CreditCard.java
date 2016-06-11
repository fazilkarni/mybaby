package com.koolfrenz.entity;

import com.koolfrenz.entity.Payment;

public class CreditCard extends Payment{
	
	public String creditCardType;

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	
	

}
