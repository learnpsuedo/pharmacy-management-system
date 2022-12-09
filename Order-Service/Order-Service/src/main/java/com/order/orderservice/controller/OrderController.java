package com.order.orderservice.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.order.orderservice.model.Order;
import com.order.orderservice.repository.OrderRepository;
import com.order.orderservice.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SuppressWarnings("unused")
@RestController
@RequestMapping("/orders")
//@CrossOrigin(origins = "http://localhost:4200/",maxAge = 3600)
public class OrderController{


	@Autowired
	private OrderService orderService;    //Service

	@Autowired
	private OrderRepository repository;


	@GetMapping("/get")
	public List<Order> getAllOrders()
	{
	return orderService.getAllOrders();
	}
	//creating a get mapping that retrieves the detail of a specific user
	@GetMapping("/get/{userId}")
	public List<Order> getOrdersByUserId(@PathVariable("userId") int userId)
	{
	return orderService.getOrdersById(userId);
	}

	@GetMapping("/{orderId}")
	public Order getOrderById(@PathVariable("orderId") int orderId) {
		return repository.findByOrderId(orderId);
	}

	@GetMapping("/orderStatus/{orderStatus}")
	List<Order> getOrderByStatus(@PathVariable("orderStatus") String orderStatus){
		return repository.findByOrderStatus(orderStatus);
	}

	//creating a delete mapping that deletes a specified book
	@DeleteMapping("/delete/{userId}")
	public void deletedrug(@PathVariable("userId") int drugsId)
	{
		orderService.delete(drugsId);
	}

	//creating post mapping that post the user detail in the database
	@PostMapping("/post")
	public Order saveDrugs(@RequestBody Order drugs)   throws Exception
	{
		return orderService.saveOrUpdate(drugs);
	}

	//creating put mapping that updates the user
	@PutMapping("/put")
	public Order update(@RequestBody Order drugs)
	{
		orderService.saveOrUpdate(drugs);
	return drugs;
	}

//	creating a post method to post all the details of the order and generates a receipt

	@PutMapping("/{id}")
	public Order updateOrderDetails(@RequestBody Order order, @PathVariable("id") int orderId) {

		return orderService.updateOrderDetails(order);

	}

	@DeleteMapping("/{orderId}")
	public String deleteOrderByUserId(@PathVariable("orderId") int orderId) {
		return orderService.deleteOrderByOrderId(orderId);
	}


}
