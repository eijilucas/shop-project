package com.wepapp.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wepapp.workshop.entity.Order;
import com.wepapp.workshop.services.OrderServices;

@RestController
@RequestMapping("/orders")
public class OrderResources {

	@Autowired
	private OrderServices service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findall() {	
		List<Order> list = service.findall();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
