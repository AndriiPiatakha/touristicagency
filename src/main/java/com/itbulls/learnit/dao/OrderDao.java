package com.itbulls.learnit.dao;

import java.util.List;

import com.itbulls.learnit.pojos.Order;

public interface OrderDao {
	Order getOrderById(int orderId);

	List<Order> getAllOrders();

	List<Order> getOrdersByUserId(int userId);

	boolean deleteOrder(int orderId);

	int createOrder(int userId);
}
