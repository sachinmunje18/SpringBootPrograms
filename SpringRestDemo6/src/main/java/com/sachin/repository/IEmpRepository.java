package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.data.Employee;

public interface IEmpRepository extends JpaRepository<Employee, Integer>{

}
