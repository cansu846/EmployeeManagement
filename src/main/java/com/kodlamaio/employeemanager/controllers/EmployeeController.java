package com.kodlamaio.employeemanager.controllers;

import com.kodlamaio.employeemanager.model.Employee;
import com.kodlamaio.employeemanager.service.abstracts.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private IService service;

    @GetMapping()
    public List<Employee> getAllEmployees() {
        List<Employee> employees = service.findAllEmployees();
        return employees;
    }

    @GetMapping("find/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        Employee employee = service.findEmployeeById(id);
        return employee;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
        return employee;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
    }


}
