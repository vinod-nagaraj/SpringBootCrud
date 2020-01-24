package com.example.crud.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.crud.dto.AddEmployeeRequestDto;
import com.example.crud.dto.ResponseDto;
import com.example.crud.entity.Company;
import com.example.crud.entity.Employee;
import com.example.crud.exception.EmailAndMobNumNotFoundException;
import com.example.crud.exception.ResourceIdNotFoundException;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.exception.ResourceUpdateFailedException;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.service.EmployeeService;
import com.example.crud.util.AppUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Iterable<Employee> getAllEmployees() {
		logger.info("Inside getAllEmployee of EmployeeServiceImpl ");
		return employeeRepository.findAll();

	}

	@Override
	public ResponseDto addEmployee(AddEmployeeRequestDto addEmployeeRequestDto) {
		logger.info("Inside addEmployee of EmployeeServiceImpl ");
		Employee employee = new Employee();
		BeanUtils.copyProperties(addEmployeeRequestDto, employee);
		employeeRepository.save(employee);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(AppUtil.ADDED_SUCCESSFULLY);
		responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return responseDto;
		
	}

	@Override
	public ResponseDto deleteEmployeeById(int id) {
		logger.info("Inside deleteEmployeeById of EmployeeServiceImpl");
		Employee employee = new Employee();
		if (employee.getId() == 0) {
			throw new ResourceNotFoundException(AppUtil.NO_ID_FOUND);
		}
		employeeRepository.deleteById(id);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(AppUtil.DELETED_SUCCESSFULLY);
		responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return responseDto;

	}

	@Override
	public String updateEmployeeById(AddEmployeeRequestDto addEmployeeRequestDto, int id) {
		logger.info("Inside updateEmployeeById of EmployeeServiceImpl");
		if (addEmployeeRequestDto.equals(null) || addEmployeeRequestDto.toString().isEmpty() || id == 0) {
			throw new ResourceUpdateFailedException(AppUtil.ENTER_PROPER_VALUES);
		}
		Employee employee1 = new Employee();
		employee1.setId(id);
		employee1.setFirstName(addEmployeeRequestDto.getFirstName());
		employee1.setLastName(addEmployeeRequestDto.getLastName());
		employee1.setAddress(addEmployeeRequestDto.getAddress());
		employee1.setEmail(addEmployeeRequestDto.getEmail());
		employee1.setMobNum(addEmployeeRequestDto.getMobNum());
		employee1.setAge(addEmployeeRequestDto.getAge());
		employeeRepository.save(employee1);
		return AppUtil.UPDATE_SUCCESS;
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		logger.info("Inside getEmployeeById of EmployeeServiceImpl");
		Optional<Employee> emp = employeeRepository.findById(id);
		if (!emp.isPresent()) {
			throw new ResourceIdNotFoundException(AppUtil.NO_RECORD_FOUND);
		}
		return emp;
	}

	@Override
	public String deleteAll() {
		logger.info("Inside deleteAll of EmployeeServiceImpl");
		employeeRepository.deleteAll();
		return AppUtil.DELETED_ALL_RECORD_SUCCESSFULLY;
	}

	@Override
	public Optional<List<Employee>> findByEmailAndMobNum(String email, String mobNum) {
		logger.info("Inside findByEmailAndMobNum of EmployeeServiceImpl");
		if (email.isEmpty() && mobNum.isEmpty()) {
			throw new EmailAndMobNumNotFoundException(AppUtil.ENTER_PROPER_EMAIL_AND_MOBNUM);
		}
		return employeeRepository.findByEmailAndMobNum(email, mobNum);

	}

	@Override
	public List<Employee> getEmployeeByName(String firstName, String lastName) {
		logger.info("Inside getEmployeeByName of EmployeeServiceImpl");
		return employeeRepository.getEmployeeByName(firstName, lastName);
	}

	@Override
	public Collection<Employee> getEmployeeAddressByLastName(String lastName) {
		logger.info("Inside getEmployeeAddressByLastName of EmployeeServiceImpl");
		return employeeRepository.getEmployeeAddressByLastName(lastName);
	}

	@Override
	public List<Company> getCompanyName(String name) {
		logger.info("Inside getCompanyName of EmployeeServiceImpl");
		return employeeRepository.getCompanyName(name);
	}

}
