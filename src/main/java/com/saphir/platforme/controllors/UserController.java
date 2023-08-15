package com.saphir.platforme.controllors;

import com.saphir.platforme.entity.User;
import com.saphir.platforme.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class UserController {
    @Autowired
    private  IEmployeeService employeeService;

    @GetMapping("employee/find/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable("id") Long id) {
        User employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("employee/all")
    public ResponseEntity<List<User>> getAllEmployees() {
        List<User> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("employee/add")
    public ResponseEntity<User> addEmployee(@RequestBody User employee) {
        User newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("employee/update")
    public ResponseEntity<User> updateEmployee(@RequestBody User employee) {
     employeeService.updateEmployee(employee);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("employee/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
