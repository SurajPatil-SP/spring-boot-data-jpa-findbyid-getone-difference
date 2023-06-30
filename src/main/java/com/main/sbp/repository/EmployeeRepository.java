package com.main.sbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.sbp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
