package com.main.sbp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.main.sbp.entity.Department;
import com.main.sbp.entity.Employee;
import com.main.sbp.repository.DepartmentRepository;
import com.main.sbp.repository.EmployeeRepository;

@Service
@Transactional
public class HRService {
	
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Department createDepartment() {
        Department dept = new Department();
        dept.setName("Product & Engg");
        return departmentRepository.save(dept);
    }

    public void createEmployee1(long deptId) {
    	createDepartment();
        final Department pne = departmentRepository.getOne(deptId); 
        Employee employee = new Employee();
        employee.setName("Foo 1");
        employee.setDepartment(pne);
        employeeRepository.save(employee);
    }
    
    public void createEmployee2(long deptId) {
        Optional<Department> pne = departmentRepository.findById(deptId);
        Employee employee = new Employee();
        employee.setName("Foo 1");
        pne.ifPresent(department -> {
            employee.setDepartment(department);
        });
        employeeRepository.save(employee);
    }

}
