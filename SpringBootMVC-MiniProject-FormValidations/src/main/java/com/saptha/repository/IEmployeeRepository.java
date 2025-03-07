package com.saptha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saptha.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
