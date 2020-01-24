package com.example.crud.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud.dto.AddEmployeeRequestDto;
import com.example.crud.dto.ResponseDto;
import com.example.crud.entity.Company;
import com.example.crud.entity.Employee;

@Service

public interface EmployeeService {

	public Iterable<Employee> getAllEmployees();

	public ResponseDto addEmployee(AddEmployeeRequestDto addEmployeeRequestDto);

	public ResponseDto deleteEmployeeById(int id);

	public String updateEmployeeById(AddEmployeeRequestDto addEmployeeRequestDto, int id);

	public Optional<Employee> getEmployeeById(int id);

	public String deleteAll();

	public Optional<List<Employee>> findByEmailAndMobNum(String email, String mobNum);

	public List<Employee> getEmployeeByName(String firstName, String lastName);

	public Collection<Employee> getEmployeeAddressByLastName(String lastName);

	public List<Company> getCompanyName(String name);

}
