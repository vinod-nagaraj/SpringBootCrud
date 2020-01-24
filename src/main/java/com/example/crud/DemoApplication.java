package com.example.crud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* The DemoApplication program implements an application that
* performs basic CRUD operations on employee by creating, reading, updating, deleting employees
* The Application also performs some named query, custom query and native query and excute over JPA named query.
*
* @author  Vinod B N
* @version 1.0
* @since   1994-09-26
*/

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
