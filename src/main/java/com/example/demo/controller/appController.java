package com.example.demo.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.employee;
import com.example.demo.service.appService;


@RestController
public class appController {
	@Autowired
	private appService service;
	
	@GetMapping("/employee")
	public ResponseEntity<List<employee>> getAll(){
		List<employee>list =service.getAll();
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<employee>> getById(@PathVariable("id")int id) {
		Optional<employee> elist=service.getById(id);
		if(elist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		return ResponseEntity.of(Optional.of(elist));
		
	}
	
	@PostMapping("/employee")
	public ResponseEntity<employee> addEmp(@RequestBody employee emp) {
		employee e=null;;
		
		try {
			e=this.service.addEmp(emp);
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		} catch (Exception e2) {
			e2.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void>delemp(@PathVariable("id")int id) {
		try {
			this.service.delEmp(id); 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<employee> updateEmp(@RequestBody employee updatedEmp,@PathVariable("id")int id) {
		
		try {
			employee eemp=service.findById(updatedEmp,id);
			eemp.setId(id);
			eemp.setName(updatedEmp.getName());
			eemp.setSalary(updatedEmp.getSalary());
		
			service.updateEmp(eemp);
			return ResponseEntity.ok().body(updatedEmp);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
			
			
			
		
		  
		
	}
	

}
