package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.OrderResponse;
import com.dalafarm.vendor.model.OrderStatusResponse;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Vu on 8/13/2017.
 */
@RestController
@RequestMapping("v1")
public class OrderController {

	@Autowired
	LogisticService ghtkService;

	@Autowired
	OrderRepository orderRepository;

	@RequestMapping("order/{id}")
	public Object getOrder(@PathVariable("id") Long id) {
		return "getOrder";
	}

	@RequestMapping(value = "order/{id}/status", method = RequestMethod.GET)
	public OrderStatusResponse getOrderStatus(@PathVariable("id") String orderId) {
		return ghtkService.getOrderStatus(orderId);
	}

	@RequestMapping(value = "orders", method = RequestMethod.GET)
	public Object getAllOrders() {
		return orderRepository.findAll();
	}

	@RequestMapping(value = "order", method = RequestMethod.POST)
	public OrderResponse order(@RequestBody @Valid Order order) {
		return ghtkService.order(order);
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Order not found")
	public void notFoundExceptionHandler(ResourceNotFoundException ex) {
	}
}
