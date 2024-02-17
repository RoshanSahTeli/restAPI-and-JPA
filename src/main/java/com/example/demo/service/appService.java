package com.example.demo.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.empRepository.userRepository;
import com.example.demo.entity.employee;

@Component
public class appService {
	@Autowired
	private userRepository repo;
	
	public List<employee> getAll(){
		List<employee> list=repo.findAll();
		return list;
	}
	
	public Optional<employee> getById(int id) {
		Optional<employee> e=repo.findById(id);
		return e;
	}
	
	
	public employee addEmp(employee emp) {
		repo.save(emp);
		return emp;
	}
	
	public void delEmp(int id) {
		repo.deleteById(id);
	}
	
	
	public employee findById(employee e,int id) {
		repo.findById(id);
		return e;
	}
	
	public employee updateEmp(employee emp) {
		repo.save(emp);
		return emp;
	}
}
