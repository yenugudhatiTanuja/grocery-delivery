package com.example.springboot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.model.Customer;
import com.example.springboot.repository.CustomerRepository;
import com.example.springboot.service.CustomerService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class CustomerTestCase {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;


	@Test
	@Disabled
	@Order(1)
	public void createCustomer() {
		Customer customer = new Customer();
		customer.setEmailID("aravind@gmail.com");
		customer.setFirstName("aravind");
		customer.setPassword("Aravind@123");
		customer.setLastName("ram");
		assertNotNull(customerRepository.save(customer));
	}

	@Test
	//@Disabled
	@Order(2)
	public void loginCustomer() {
		Optional<Customer> customer = customerRepository.findByEmailIDAndPassword("aravind@gmail.com",
				"Aravind@123");
		Customer newCustomer = null;
		if (customer.isPresent()) {
			newCustomer = customer.get();
		}
		assertThat(newCustomer);
	}

	@Test
	//@Disabled
	@Order(3)
	public void testReadAllCustomer() {
		List<Customer> customer = customerRepository.findAll();
		assertThat(customer).size().isGreaterThan(0);
	}

	@Test
	//@Disabled
	@Order(4)
	public void getCustomerById() {
		Customer customer = customerService.getCustomerById(5000);
		assertThat(customer.getCustomerId()).isEqualTo(5000);
	}

//	@Test
//	//@Disabled
//	@Order(5)
//	public void updateCustomer() {
//		Customer customer = customerService.updateCustomer(customer, 0);
//		customer.setPassword("Aravind@111");
//		Customer updateCustomer = customerRepository.save(customer);
//		assertThat(updateCustomer.password);
//	}

	@Test
	@Disabled
	@Order(6)
	public void deleteCustomer() {
		Customer customer = customerService.getCustomerById(8000);
		customerRepository.delete(customer);
	}
}