package com.example.crud.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dto.AddEmployeeRequestDto;
import com.example.crud.dto.ResponseDto;
import com.example.crud.entity.Company;
import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeService;

/**
 * 
 * @author Vinod B N
 * @version 1.0
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * 
	 * @param employee of employee
	 * @return string as response
	 */
	@PostMapping("/employees")
	public ResponseDto addEmployee(@RequestBody AddEmployeeRequestDto addEmployeeRequestDto) {
		return employeeService.addEmployee(addEmployeeRequestDto);
	}

	/**
	 * 
	 * @return List of employee
	 */
	@GetMapping("/employees")
	public Iterable<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	/**
	 * 
	 * @param id of employee
	 */
	@DeleteMapping("/employee/{id}")
	public ResponseDto deleteEmployeeById(@PathVariable Integer id) {
		return employeeService.deleteEmployeeById(id);
	}

	/**
	 * 
	 * @param employee of employee
	 * @param id       of employee
	 * @return string
	 */
	@PutMapping("/employee/{id}")
	public String updateEmployeeById(@RequestBody AddEmployeeRequestDto addEmployeeRequestDto, @PathVariable int id) {
		return employeeService.updateEmployeeById(addEmployeeRequestDto, id);
	}

	/**
	 * 
	 * @param id of employee
	 * @return employee
	 */
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	/**
	 * 
	 * @return string as response
	 */
	@DeleteMapping("/employee")
	public String deleteAll() {
		return employeeService.deleteAll();
	}

	/**
	 * 
	 * @param email  of employee
	 * @param mobNum of employee
	 * @return String of email and mobnum of employee
	 */
	@GetMapping("/employee/{email}/{mobNum}")
	public Optional<List<Employee>> findByEmailAndMobNum(@PathVariable String email, @PathVariable String mobNum) {
		return employeeService.findByEmailAndMobNum(email, mobNum);
	}

	/**
	 * 
	 * @param firstName of employee
	 * @param lastName  of employee
	 * @return names of employee
	 */
	@GetMapping("/employeebyname")
	public List<Employee> getEmployeeByName(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeService.getEmployeeByName(firstName, lastName);
	}

	/**
	 * 
	 * @param lastName of employee
	 * @return address of employee
	 */
	@GetMapping("/employeelastname")
	public Collection<Employee> getEmployeeAddressByLastName(@RequestParam String lastName) {
		return employeeService.getEmployeeAddressByLastName(lastName);
	}

	/**
	 * 
	 * @param name of company
	 * @return name
	 */
	@GetMapping("/companyname")
	public List<Company> getCompanyName(@RequestParam String name) {
		return employeeService.getCompanyName(name);
	}
}
