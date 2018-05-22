package com.jdbc.demo.jdbcdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.demo.jdbcdemo.entity.Customers;

@Repository // talks to the DB
public class CustomersJdbcDao {

	// need to use JdbcTemplate to execute a query
	@Autowired // use Spring to autowire it
	JdbcTemplate jdbcTemplate;

	// select * from customers
	public List<Customers> findAll() {
		// first param is the query, second param is the default row mapper for Spring
		// (because all of the column names match the variables in my customer class there
		// is no need to do an explicit row mapper (note: i have not used all the columns in the table)
		return jdbcTemplate.query("select * from customers", new BeanPropertyRowMapper<Customers>(Customers.class));
	}


	public int insertCustomer(String id, String compName, String contName, String contTitle, String phone) {
		
		String insertQuery = "INSERT INTO customers(CompanyName, ContactTitle, ContactName, CustomerID, phone) values (?,?,?,?,?)";

		return jdbcTemplate.update(insertQuery, compName, contTitle, contName, id, phone);
	}

	public int updateCustomer(String id, String contName) {
		
		String insertQuery = "UPDATE customers set contactName=? WHERE customerID = ?";

		return jdbcTemplate.update(insertQuery, contName, id);
	}

	public int deleteCustomer(String id) {
		
		String insertQuery = "DELETE from customers WHERE customerID = ?";

		return jdbcTemplate.update(insertQuery, id);
	}
}
