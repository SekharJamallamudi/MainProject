package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.entity.Employee;

public interface EmployeeService {

	Employee dataInsert(Employee employee);

	List<Employee> dataAll();

	Employee dataGetId(Integer id);

	String dataDelete(Integer id);

	Employee dataUpdate(Integer id, Employee employee);

	Employee dataPatch(Integer id, Map<String, Object> map);

	Employee registerEmployee(Employee employee);

}
