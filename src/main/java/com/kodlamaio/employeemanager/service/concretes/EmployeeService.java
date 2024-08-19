package com.kodlamaio.employeemanager.service.concretes;

import com.kodlamaio.employeemanager.exceptions.UserNotFoundException;
import com.kodlamaio.employeemanager.model.Employee;
import com.kodlamaio.employeemanager.repository.EmployeeRepo;
import com.kodlamaio.employeemanager.service.abstracts.IService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.UUID;

@Service
@AllArgsConstructor
class EmployeeService implements IService {
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
       employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
