package com.sachin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.data.Employee;
import com.sachin.repository.IEmpRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

	@GetMapping("/login")
	public String login(@RequestParam String UID, @RequestParam String PWD) throws Exception {
		System.out.println("Given Data is: User ID: " + UID + " Password: " + PWD);

		if (!UID.equalsIgnoreCase("Charan")) {
			throw new UserNotFoundException("Given ID must be Charan only...");
		}

		if (UID.equalsIgnoreCase("Charan") && PWD.equalsIgnoreCase("admin")) {
			return "You are a valid user";
		} else {
			return "Invalid user";
		}
	}

	// Versoning

	@GetMapping("/v1/hello")

	public String hello() {

		return "This is version 1 of hello.....";
	}

	@GetMapping("/v2/hello")

	public String hellov2() {

		return "This is version 2 of hello...";

	}

	@Autowired
	IEmpRepository empRepo;

	@GetMapping("/getAllRecords")
	public List<Employee> getAllRecords() {
		List<Employee> empLst = empRepo.findAll();
		return empLst;

	}

	@PostMapping("/addRecord")
	public Employee addRecord(@RequestBody Employee employee) {
		return empRepo.save(employee); // Directly return the saved employee
	}

	@PutMapping("/updateRecord/{id}")
	public Employee updateRecord(@PathVariable int id, @RequestBody Employee employeeDetails)
			throws ResourceNotFoundException {
		Employee employee = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		employee.setName(employeeDetails.getName());
		employee.setDept(employeeDetails.getDept());
		employee.setDesignation(employeeDetails.getDesignation());
		// Set other fields as necessary

		return empRepo.save(employee);
	}

	@DeleteMapping("/deleteRecord/{id}")
	public Map<String, Boolean> deleteRecord(@PathVariable int id) throws ResourceNotFoundException {
		Employee employee = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		empRepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	// -----------------------------------------------------------------------------------
	// PUT Mapping to update the data
	@PutMapping("/updateData")
	public String updateData(@RequestBody Employee emp) {
		System.out.println("Given Data to update is: " + emp);
		// Add your database update logic here
		return "Given record is updated in the db Successfully....";
	}

	// DELETE Mapping to delete the data
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		System.out.println("Given ID to delete is: " + id);
		// Add your database deletion logic here
		return "Given record with Id: " + id + " is deleted successfully";
	}

}
