package com.koolfrenz.service;

import org.springframework.transaction.annotation.Transactional;

import com.koolfrenz.dao.CustomerDAO;
import com.koolfrenz.model.Customer;

public class CustomerManagerImpl implements CustomerManager{
	CustomerDAO customerDAO;
	
	
	@Transactional
	public void createCustomer(Customer customer) {
		customerDAO.create(customer);
		
	}


	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
