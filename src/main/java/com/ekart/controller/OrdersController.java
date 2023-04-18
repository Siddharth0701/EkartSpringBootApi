package com.ekart.controller;

import java.util.List;

import com.ekart.dto.OrdersData;
import com.ekart.service.OrdersService;

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
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;

	@GetMapping
	public List<OrdersData> findAll() {
		return ordersService.findAll();
	}

	@GetMapping("{id}")
	public OrdersData findById(@PathVariable Long id) {
		return ordersService.findById(id);
	}

	@PostMapping
	public OrdersData create(@RequestBody OrdersData ordersData) {
		return ordersService.create(ordersData);

	}

	@DeleteMapping("{id}")
	public boolean delete(@PathVariable Long id) {
		return ordersService.delete(id);
	}

	@PutMapping("{id}")
	public boolean updateOrders(@RequestBody OrdersData ordersData, @PathVariable("id") Long id) {
		return ordersService.update(ordersData, id);

	}
}