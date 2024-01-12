package com.demo.serviceImpl;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
   
	@Autowired
	public EmployeeRepository employeeRepository;
	@Override
	public Employee dataInsert(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
		 
	}

	@Override
	public List<Employee> dataAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee dataGetId(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public String dataDelete(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return "Deleted with id:"+id;
	}

	@Override
	public Employee dataUpdate(Integer id, Employee employee) {
		// TODO Auto-generated method stub
		Employee employ = employeeRepository.findById(id).get();
		employ.setName(employee.getName());
		employ.setLoc(employee.getLoc());
		return employeeRepository.save(employ);
	}

	@Override
	public Employee dataPatch(Integer id, Map<String, Object> map) {
		// TODO Auto-generated method stub
		Employee employe = employeeRepository.findById(id).get();
		map.forEach((key,value)->{
			
			Field field = ReflectionUtils.findRequiredField(Employee.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, employe, value);
		});
		return employeeRepository.save(employe);
	}

	@Override
	public Employee registerEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

}

