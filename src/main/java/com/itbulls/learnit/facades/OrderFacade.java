package com.itbulls.learnit.facades;

import java.util.List;

import com.itbulls.learnit.dao.impl.OrderDaoImpl;
import com.itbulls.learnit.pojos.Order;

public class OrderFacade {
	OrderDaoImpl oDao = new OrderDaoImpl();

	public List<Order> getOrders() {
		return oDao.getAllOrders();
	}

	public int createOrder(int userId) {
		return oDao.createOrder(userId);
	}

	public boolean deleteOrder(int orderId) {
		return oDao.deleteOrder(orderId);
	}
	public List<Order> getOrdersByUserId(int id){
		return oDao.getOrdersByUserId(id);
	}
}
