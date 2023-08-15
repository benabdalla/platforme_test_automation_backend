package com.saphir.platforme.service;

import com.saphir.platforme.config.UserNotFoundException;
import com.saphir.platforme.entity.User;
import com.saphir.platforme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    UserRepository employeeRepository;

    @Autowired
    public EmployeeService(UserRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public User addEmployee(User employee) {
      //  employee.setId(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<User> findAllEmployees() {
        return employeeRepository.findByRoleNot("ADMIN");
    }

    @Override
    public User updateEmployee(User employee) {
       return employeeRepository.findById(employee.getId()).map(
               (emp)->{
                   emp.setUsername(employee.getUsername());
                   emp.setEmail(employee.getEmail());
                   emp.setPhone(employee.getPhone());
                   emp.setJobTitle(employee.getJobTitle());
                   return employeeRepository.save(emp);
               }
       ).orElse(null);


    }

    @Override
    public User findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
