
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;


//@CrossOrigin(origins="http://localhost:3000")
@RestController

@RequestMapping("/api/customers")
public class Customercontroller {

	@Autowired
	CustomerService custser;
	
	//@Autowired
	//Book book;
	
	/*
	@GetMapping("/viewbooks")
	public List<Book> getBook()
	{
		return book.getBook();
	}*/ // shd create function in bookservice;
	/*
	@GetMapping("/bookid/{bookid}")
	public Book getbook(@PathVariable String bookid)
	{
		return book.getBook(bookid);
	}*/
	
	//order book
	//review book
	// rating book
	
	
	
	@GetMapping("/list")
	public List<Customer> getCustomer()
	{
		return custser.getCustomer();
		
	}
	@GetMapping("/cusid/{CusId}")
	public Customer getCustomer(@PathVariable String CusId)
	{
		return custser.getCustomer(CusId);
	}
	@PostMapping("/add")
	public String addCustomer(@RequestBody Customer customer)
	{
		 custser.add(customer);
		 return "Insert successfull";
	}
	@PutMapping("/update")
	public String updateCustomer(@RequestBody Customer customer)
	{
		custser.update(customer);
		return "update successful";
	}
	
	@DeleteMapping("/delete/{CusId}")
	public String deleteCustomer(@PathVariable String CusId)
	{
		custser.delete(CusId);
		return "deleted sucessfully!!!";
		
	}
}

