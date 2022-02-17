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
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/orders")
public class OrderWebController {

@Autowired
OrderService orserv;

@GetMapping("/listorders")
public List<Order> getOrder() {
	return orserv.getOrder();
}

/*@GetMapping("/ordid/{orderid}")
public Order getorder(@PathVariable String orderid){
	return orserv.getorder(orderid);
}//Read-1     */

/*
@GetMapping("/orderc/{custid}")
public List<Order> getOrder(@PathVariable String custid){
	return orserv.getOrderBycustid(custid);
}
*/

@GetMapping("/orderc/{custid}")
public List<Order> getOrder(@PathVariable String custid){
	return orserv.getOrderBycustid(custid);
	
	
}



@PostMapping("/add")
public String addOrder(@RequestBody Order order) {
	 orserv.add(order);
	 return "succesfully added";
}//Create and Update

@DeleteMapping("/delete/{orderid}")
public String  deletebyid(@PathVariable String orderid) {
	orserv.delete(orderid);
	return "deleted";
}//Delete

@PutMapping("/update")
public String updateCustomer(@RequestBody Order order)
{
	orserv.update(order);
	return "update successful";
}


}
