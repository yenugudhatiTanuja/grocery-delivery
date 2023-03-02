package com.example.springboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.model.Admin;
import com.example.springboot.repository.AdminRepository;
import com.example.springboot.repository.CustomerRepository;



@SpringBootTest
class AdminTestCase {
	@Autowired	
	private AdminRepository adminRepository;
	private CustomerRepository customerRepository;
	



	@Test
	public void testCreate()  {
		Admin admin=new Admin();
	admin.setFirstName("Bharath");
	admin.setLastName("Gowda");
admin.setAdminEmailId("bharath@gmail.com");
	admin.setAdminPassword("Asus12312");

		
		assertNotNull(	adminRepository.save(admin));
	
   
	   
	}

	@Test
	void contextLoads() {
	}

}