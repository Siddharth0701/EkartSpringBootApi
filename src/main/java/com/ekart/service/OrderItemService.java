package com.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ekart.dao.IOrderItemRepository;
import com.ekart.dto.OrderItemData;
import com.ekart.model.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class OrderItemService implements IOrderItemService {

	@Autowired
	private IOrderItemRepository orderItemRepository;

	// DTO=>Entity
	private OrderItem getOrderItemEntity(OrderItemData orderItemData) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(orderItemData.getOrderItemId());
		orderItem.setProduct(orderItemData.getProduct());
		orderItem.setQuantity(orderItemData.getQuantity());
		return orderItem;
	}

//		Entity=>DTO

	private OrderItemData getOrderItemData(OrderItem orderItem) {
		OrderItemData orderItemData = new OrderItemData();
		orderItemData.setOrderItemId(orderItem.getOrderItemId());
		orderItemData.setProduct(orderItem.getProduct());
		orderItemData.setQuantity(orderItem.getQuantity());
		return orderItemData;
	}

	@Override
	public List<OrderItemData> findAll() {
		List<OrderItemData> orderItemDataList = new ArrayList<>();
		List<OrderItem> orderItems = orderItemRepository.findAll();
		orderItems.forEach(orderItem -> {
			orderItemDataList.add(getOrderItemData(orderItem));
		});

		return orderItemDataList;
	}

	@Override
	public OrderItemData findById(Long id) {
		Optional<OrderItem> orderItemsOptional = orderItemRepository.findById(id);
		if (orderItemsOptional == null) {
			new EntityNotFoundException("orderItem Not Found");

		}
		return getOrderItemData(orderItemsOptional.get());
		
	}

	@Override
	public OrderItemData create(OrderItemData orderItemData) {
		OrderItem orderItem = getOrderItemEntity(orderItemData);

		return getOrderItemData(orderItemRepository.save(orderItem));

	}

	@Override
	public boolean delete(Long id) {
		OrderItem orderItem = orderItemRepository.findById(id).get();
		if (orderItem != null) {
			orderItemRepository.deleteById(id);
			return true;

		} else {
			return false;
		}

	}

	public boolean update(OrderItemData orderItemData, Long orderItemId) {
		OrderItem orderItem2 = orderItemRepository.findById(orderItemId).get();
		if (orderItem2 != null) {

			orderItem2.setProduct(orderItemData.getProduct());
			orderItem2.setQuantity(orderItemData.getQuantity());
			orderItemRepository.save(orderItem2);
			return true;
		} else {
			return false;
		}

	}

}
