package com.jdbc.demo.jdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jdbc.demo.jdbcdemo.dao.CustomersJdbcDao;

@Controller
public class CustomersController {

	@Autowired
	CustomersJdbcDao dao;

	@RequestMapping("/")
	public ModelAndView index() {

		return new ModelAndView("index", "test", dao.findAll());

	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") String id) {
		dao.deleteCustomer(id);

		return new ModelAndView("index", "test", dao.findAll());
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("id") String id) {
		
		return new ModelAndView("update", "id", id);
	}
	
	@RequestMapping("/updateCust")
	public ModelAndView updateCust(@RequestParam("id") String id, @RequestParam("name") String name) {
		dao.updateCustomer(id, name);

		return new ModelAndView("index", "test", dao.findAll());
	}

	@RequestMapping("/addNewCust")
	public ModelAndView addNewCustomer(@RequestParam("id") String id, @RequestParam("contName") String name,
			@RequestParam("title") String title, @RequestParam("compName") String compName,
			@RequestParam("phone") String phone) {
		dao.insertCustomer(id, compName, name, title, phone);

		return new ModelAndView("index", "test", dao.findAll());
	}
	
	
}