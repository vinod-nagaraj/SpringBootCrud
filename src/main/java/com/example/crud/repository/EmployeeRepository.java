package com.example.crud.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.Company;
import com.example.crud.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Optional<List<Employee>> findByEmailAndMobNum(String email, String mobNum);

	@Query("SELECT e FROM Employee e WHERE e.firstName=?1 AND e.lastName=?2")
	List<Employee> getEmployeeByName(String firstName, String lastName);

	@Query("SELECT address FROM Employee s WHERE s.lastName=?1")
	Collection<Employee> getEmployeeAddressByLastName(String lastName);

	@Query("SELECT c FROM Company c WHERE c.name= ?1")
	List<Company> getCompanyName(String name);

}
