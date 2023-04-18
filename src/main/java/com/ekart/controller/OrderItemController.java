package com.ekart.controller;

import java.util.List;

import com.ekart.dto.OrderItemData;
import com.ekart.service.OrderItemService;

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

@RestController
@RequestMapping(value="api/orderitems",produces="application/json")
@CrossOrigin(origins = "*")
public class OrderItemController {
	@Autowired
	private OrderItemService  orderItemService;
	
	@GetMapping
	public List<OrderItemData> findAll() {
		return orderItemService.findAll();
	}

	@GetMapping("{id}")
	public OrderItemData findById(@PathVariable Long id) {
		return orderItemService.findById(id);
	}

	@PostMapping
	public OrderItemData create(@RequestBody OrderItemData orderItemData) {
		return orderItemService.create(orderItemData);

	}

	@DeleteMapping("{id}")
	public boolean delete(@PathVariable Long id) {
		return orderItemService.delete(id);
	}

	@PutMapping("{id}")
	public boolean updateOrderItem(@RequestBody OrderItemData orderItemData, @PathVariable("id") Long orderItemId) {
		return orderItemService.update(orderItemData, orderItemId);

	}


}
