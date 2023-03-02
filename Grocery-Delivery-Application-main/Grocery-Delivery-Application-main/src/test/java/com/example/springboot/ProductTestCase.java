package com.example.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepository;


@SpringBootTest
class ProductTestCase {

	@Autowired
	private ProductRepository productRepository;

	@Test
	@Order(1)
	@Disabled
	public void addProduct() {
		Product product = new Product();
		product.setQuantity(8);
		product.setProductname("moong dal");
		product.setMrpPrice(120);
		product.setDescription("moong daal");
		//product.setProductPrice(27000);
		assertNotNull(productRepository.save(product));
	}
	
	@Test
	//@Disabled
	@Order(2)
	public void getAllProduct() {
		List<Product> product = productRepository.findAll();
		assertThat(product).size().isGreaterThan(0);
	}

	@Test
	//@Disabled
	@Order(3)
	public void getProductById() {
		Product product = productRepository.findByProductId(15000).get(0);
		assertThat(product.getProductId()).isEqualTo(15000);
	}

//	@Test
//	//@Disabled
//	@Order(4)
//	public void updateProduct() {
//		Product product = productRepository.findByProductId(15000).get(15000);
//		product.setProductname("moong daal");
//		product.setQuantity(10);
//		Product updatedProduct = productRepository.save(product);
//		assertThat(updatedProduct.getProductId());
//	}

	@Test
	@Disabled
	@Order(5)
	public void deleteProduct() {
		Product product = productRepository.findByProductId(2).get(2);
		productRepository.delete(product);
	}

	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}