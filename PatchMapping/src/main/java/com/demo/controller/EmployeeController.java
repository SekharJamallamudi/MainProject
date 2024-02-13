package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

import jakarta.validation.Valid;
@RequestMapping("/user")
@RestController
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping("/insert")
    public ResponseEntity<Employee>dataInsert(@RequestBody @Valid Employee employee)
    {
		return new ResponseEntity<Employee>(employeeService.dataInsert(employee),HttpStatus.CREATED);
    }
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>>dataAll()
	{
		return new ResponseEntity<List<Employee>>(employeeService.dataAll(),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee>dataGetId(@PathVariable Integer id)
	{
		return new ResponseEntity<Employee>(employeeService.dataGetId(id),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>dataDelete(@PathVariable Integer id)
	{
		return new ResponseEntity<String>(employeeService.dataDelete(id),HttpStatus.ACCEPTED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee>dataUpdate(@PathVariable Integer id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.dataUpdate(id,employee),HttpStatus.CREATED);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<Employee>dataPatch(@PathVariable Integer id,@RequestBody Map<String,Object>map)
	{
		return new ResponseEntity<Employee>(employeeService.dataPatch(id,map),HttpStatus.CREATED);
	}
	 @PostMapping("/register")
	    public String registerUser(@RequestBody Employee employee) {
	        Employee registeredUser = employeeService.registerEmployee(employee);
	        return "User registered successfully. User details: {" +
	                "id=" + registeredUser.getId() +
	                ", firstName='" + registeredUser.getName() + '\'' +
	                ", lastName='" + registeredUser.getLoc() + '\'' +
	               
	                '}';
	    }
	
	 }

