package com.example.springboot;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.model.Cart;
import com.example.springboot.model.Customer;
import com.example.springboot.model.Order;
import com.example.springboot.model.Product;
import com.example.springboot.repository.CartRepository;
import com.example.springboot.repository.OrderRepository;
import com.example.springboot.repository.ProductRepository;
import com.example.springboot.service.CartService;
import com.example.springboot.service.ProductService;



class OrderTestCase {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartService cartService;

	@Test
	//@Order(1)
	@Disabled
	public void addOrder() {
		Order order = new Order();
		
		Cart cart = cartService.getCartById(1000);
		order.setCart(cart);
		assertNotNull(orderRepository.save(order));
	}

	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}