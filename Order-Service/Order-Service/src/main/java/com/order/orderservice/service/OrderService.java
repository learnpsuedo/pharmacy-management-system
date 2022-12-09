package com.order.orderservice.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.model.Order;
import com.order.orderservice.repository.OrderRepository;



@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;


	private static final Logger LOGGER=LoggerFactory.getLogger(OrderService.class);

	public List<Order> getAllOrders()
	{
	List<Order> orders = new ArrayList<Order>();
	orderRepository.findAll().forEach(orders1 -> orders.add(orders1));
	return orders;
	}


	public List<Order> getOrdersById(int userId)
	{
	return  orderRepository.findByUserId(userId);

	}


	public Order saveOrUpdate(Order orders)
	{
		return orderRepository.save(orders);

	}
	public void delete(int drugsId)
	{
		orderRepository.deleteById(drugsId);
	}

	public void update(Order orders, int userId)
	{
		orderRepository.save(orders);
	}

	public List<Order> getOrderByStatus(String orderStatus){
		return orderRepository.findByOrderStatus(orderStatus);
	}


	public Order updateOrderDetails(Order order) {
//		String em = "";
//		List<Address> order1 = order.getAddress();
//		for(int i = 0;i<order1.size();i++) {
//			em = order1.get(i).getEmail();
//			System.out.println(order1.get(i).getEmail());
//		}
//		 String email = em;
//		 System.out.println(email);

		 String s = order.getOrderStatus();
		 System.out.println(s);

//		 if(order.getOrderStatus().equalsIgnoreCase("cancelled")) {
//			 String html = "Sorry!,"+order.getUserId()+ "Your Order has been cancelled";
//			 emailSenderService.sendEmail(email, "Verified Order", html);
//		 }else {
//			 String html ="Your Order has been verified and shipped";
//				emailSenderService.sendEmail(email, "Verified Order", html);
//		 }


		return orderRepository.save(order);
	}

	public String deleteOrderByOrderId(int orderId) {
		orderRepository.deleteByOrderId(orderId);
		return "Successfully Deleted";
	}



}