package com.example.hrm.services;

import com.example.hrm.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees() throws RuntimeException;

    List<Employee> getEmployeeByName(String employeeName) throws RuntimeException;

    Employee getEmployeeById(String employeeCode) throws RuntimeException;
    Employee saveEmployee(Employee employee) throws Exception;

    boolean updateEmployee(String id , Employee employee) throws Exception;

    boolean deleteEmployee(String id) throws RuntimeException;
}
