package com.example.springboot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.model.Cart;
import com.example.springboot.model.Product;
import com.example.springboot.repository.CartRepository;
import com.example.springboot.service.ProductService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CartTestCase {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductService productService;

	@Test
	@Order(1)
	@Disabled
	public void addCart() {
		Cart cart = new Cart();
		
		Product product = productService.getProductByProductId(15000);
		cart.setProduct(product);
		assertNotNull(cartRepository.save(cart));
	}



}
