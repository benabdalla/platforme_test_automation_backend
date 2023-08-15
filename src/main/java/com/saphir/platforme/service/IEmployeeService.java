package com.saphir.platforme.service;

import com.saphir.platforme.entity.User;

import java.util.List;

public interface IEmployeeService {

    User addEmployee(User employee);

    List<User> findAllEmployees();

    User updateEmployee(User employee);

    User findEmployeeById(Long id);

    void deleteEmployee(Long id);
}
