package com.example.demo.empRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.employee;

public interface userRepository extends JpaRepository<employee, Integer> {
	
	

}
