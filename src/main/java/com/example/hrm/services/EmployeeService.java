package com.example.hrm.services;

import com.example.hrm.entity.Employee;
import com.example.hrm.models.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees() throws RuntimeException;

    List<Employee> getEmployeeByName(String employeeName) throws RuntimeException;

    Employee getEmployeeById(String employeeCode) throws RuntimeException;
    Employee saveEmployee(EmployeeModel employee) throws Exception;

    boolean updateEmployee(String id , EmployeeModel employee) throws Exception;

    boolean deleteEmployee(String id) throws RuntimeException;
    boolean deleteManyEmployee(List<String> employeeCode) throws RuntimeException;
}
