package com.koolfrenz.dao;

import com.koolfrenz.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDAOImpl implements CustomerDAO{
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void create(Customer customer) {
		String queryCustomer = "insert into Customer (id, name) values (?,?)";
		String queryAddress = "insert into Address (id, address,country) values (?,?,?)";
		
		jdbcTemplate.update(queryCustomer,new Object[]{customer.getId(),customer.getName()});
		System.out.println("Customer create sucessful");
		jdbcTemplate.update(queryAddress, new Object[]{customer.getAddress().getId(),customer.getAddress().getAddress()});
		System.out.println("Address create sucessful");
		
	}

}
