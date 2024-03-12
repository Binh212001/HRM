package com.example.hrm.services;

import com.example.hrm.entity.Employee;
import com.example.hrm.models.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int page,int limit) throws Exception;

    List<Employee> getEmployeeByName(String employeeName) throws Exception;

    Employee getEmployeeById(String employeeCode) throws Exception;
    Employee saveEmployee(EmployeeModel employee) throws Exception;

    boolean updateEmployee(String id , EmployeeModel employee) throws Exception;

    boolean deleteEmployee(String id) throws Exception;
    boolean deleteManyEmployee(List<String> employeeCode) throws Exception;
    long getCount() throws Exception;

}
