package com.example.hrm.services;

import com.example.hrm.entity.Employee;
import com.example.hrm.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        try {
            return employeeRepository.findAll();
        }catch (RuntimeException e) {
            throw  new RuntimeException("Could not get employees");
        }
    }

    @Override
    public List<Employee> getEmployeeByName(String employeeName) {
        try {
            return employeeRepository.findByFullName(employeeName);
        }catch (RuntimeException e) {
            throw  new RuntimeException("Could not get employees");
        }
    }

    @Override
    public Employee getEmployeeById(String employeeCode) {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeCode);
            return employee.get();
        }catch (RuntimeException e) {
            throw  new RuntimeException("Could not get employees");
        }
    }

    @Override
    public Employee saveEmployee(Employee employee) throws Exception {
        try {
            Employee oldEmployee = employeeRepository.findByEmail(employee.getEmail());
            if(oldEmployee!= null) {
               throw new Exception("Employee is already");
            }
            return employeeRepository.save(employee);
        }catch (RuntimeException e) {
            throw  new RuntimeException("Could not get employees");
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isEmpty()){
                return false;
            }
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
          return false;
        }
    }
}
