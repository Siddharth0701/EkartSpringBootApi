package com.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ekart.dao.IOrdersRepository;
import com.ekart.dto.OrdersData;
import com.ekart.exception.NoIdFoundException;
import com.ekart.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService implements IOrdersService {
	
	@Autowired
	private IOrdersRepository ordersRepository;

	private Orders getOrdersEntity(OrdersData ordersData) {
		Orders orders = new Orders();
		orders.setOrderId(ordersData.getOrderId());
		orders.setCustomer(ordersData.getCustomer());
		orders.setOrderItems(ordersData.getOrderItems());
		orders.setTimestamp(ordersData.getTimestamp());

		return orders;

	}

	private OrdersData getOrdersData(Orders orders) {
		OrdersData ordersData = new OrdersData();
		ordersData.setOrderId(orders.getOrderId());
		ordersData.setCustomer(orders.getCustomer());
		ordersData.setTimestamp(orders.getTimestamp());
		ordersData.setOrderItems(orders.getOrderItems());
		return ordersData;

	}

	@Override
	public List<OrdersData> findAll() {

		List<OrdersData> ordersDataList = new ArrayList<>();
		List<Orders> orders = ordersRepository.findAll();
		orders.forEach(orders1 -> {
			ordersDataList.add(getOrdersData(orders1));
		});

		return ordersDataList;
	}

	@Override
	public OrdersData findById(Long id) throws NoIdFoundException {
		Optional<Orders> orderOptional = ordersRepository.findById(id);
		if (orderOptional == null) {
			new NoIdFoundException("orders not Found");

		}
		return getOrdersData(orderOptional.get());
	}

	@Override
	public OrdersData create(OrdersData ordersData) {
		Orders orders = getOrdersEntity(ordersData);
		return getOrdersData(ordersRepository.save(orders));

	}

	@Override
	public boolean delete(Long id) {
		Orders orders = ordersRepository.findById(id).get();
		if (orders != null) {
			ordersRepository.deleteById(id);
			return true;

		} else {
			return false;
		}

	}
	@Override
	public boolean update(OrdersData ordersData, Long orderId) {
		Orders orders = ordersRepository.findById(orderId).get();
		if (orders != null) {

			orders.setCustomer(ordersData.getCustomer());
			orders.setOrderItems(ordersData.getOrderItems());
			orders.setTimestamp(ordersData.getTimestamp());

			ordersRepository.save(orders);
			return true;

		} else {
			return false;
		}

	}

}
