package com.saphir.platforme.service;

import com.saphir.platforme.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> findAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee findEmployeeById(Long id);

    void deleteEmployee(Long id);
}
