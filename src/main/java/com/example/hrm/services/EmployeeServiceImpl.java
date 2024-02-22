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
            throw  new RuntimeException("Get error: " + e.getMessage());

        }
    }

    @Override
    public List<Employee> getEmployeeByName(String employeeName) {
        try {
            return employeeRepository.findByFullName(employeeName);
        }catch (RuntimeException e) {
            throw  new RuntimeException("Get error: " + e.getMessage());

        }
    }

    @Override
    public Employee getEmployeeById(String employeeCode) {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeCode);
            return employee.get();
        }catch (RuntimeException e) {
            throw  new RuntimeException("Get error: " + e.getMessage());
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
            throw  new RuntimeException("Save error: " + e.getMessage());
        }
    }

    @Override
    public boolean updateEmployee(String id,Employee employee) throws Exception {
        try {

        Optional<Employee> oldEmployee = employeeRepository.findById(id);
        if(oldEmployee.isEmpty() ) {
            throw  new Exception("Can not find employee");
        }
        oldEmployee.get().setFullName(employee.getFullName());
        oldEmployee.get().setEmail(employee.getEmail());
        oldEmployee.get().setAddress(employee.getAddress());
        oldEmployee.get().setBirthday(employee.getBirthday());
        oldEmployee.get().setAddress(employee.getAddress());
        oldEmployee.get().setGender(employee.getGender());
        oldEmployee.get().setJobPosition(employee.getJobPosition());
        oldEmployee.get().setDepartmentId(employee.getDepartmentId());
        oldEmployee.get().setManager(employee.getManager());
        oldEmployee.get().setPassword(employee.getPassword());
        oldEmployee.get().setTaxCode(employee.getTaxCode());
        oldEmployee.get().setImagePath(employee.getImagePath());

        employeeRepository.save(oldEmployee.get());
        return false;
        }catch (RuntimeException e){
            throw  new Exception("Update Error: " + e.getMessage());
        }
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
            throw  new RuntimeException("Delete error: " + e.getMessage());
        }
    }
}
