package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.model.Cart;



@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	
}