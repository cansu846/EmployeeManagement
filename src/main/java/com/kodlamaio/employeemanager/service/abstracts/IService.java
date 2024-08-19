package com.kodlamaio.employeemanager.service.abstracts;

import com.kodlamaio.employeemanager.model.Employee;

import java.util.List;

public interface IService {
    public Employee addEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public Employee updateEmployee(Employee employee);
    public Employee findEmployeeById(Long id);
    public void deleteEmployee(Long id);

}
