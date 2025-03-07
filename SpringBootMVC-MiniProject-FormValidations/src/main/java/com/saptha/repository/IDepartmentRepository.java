package com.saptha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saptha.model.Dept;

public interface IDepartmentRepository extends JpaRepository<Dept, Integer> {
	@Query("select deptno from Dept")
	public List<Integer> fetchAllDeptNos();
}
