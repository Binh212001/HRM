package com.example.hrm.services;

import com.example.hrm.entity.Department;
import com.example.hrm.entity.Employee;
import com.example.hrm.models.EmployeeModel;
import com.example.hrm.repositories.DepartmentRepository;
import com.example.hrm.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Employee> getEmployees(int page, int limit) {
        try {
            Pageable pageable = PageRequest.of(page, limit);
            return employeeRepository.findAllEmployee(pageable);
        } catch (Exception e) {
            throw new RuntimeException("Get error: " + e.getMessage());

        }
    }

    @Override
    public List<Employee> getEmployeeByName(String employeeName) throws Exception {
        try {
            return employeeRepository.findByFullName(employeeName);
        } catch (Exception e) {
            throw new RuntimeException("Get error: " + e.getMessage());

        }
    }

    @Override
    public Employee getEmployeeById(String employeeCode) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeCode);
            return employee.get();
        } catch (Exception e) {
            throw new RuntimeException("Get error: " + e.getMessage());
        }
    }

    @Override
    public Employee saveEmployee(EmployeeModel employee) throws Exception {
        try {
            Employee oldEmployee = employeeRepository.findByEmail(employee.getEmail());
            if (oldEmployee != null) {
                throw new Exception("Employee is already");
            }
            Employee newEmployee = mapToEmployee(employee);

            return employeeRepository.save(newEmployee);
        } catch (Exception e) {
            throw new RuntimeException("Save error: " + e.getMessage());
        }
    }

    @Override
    public boolean updateEmployee(String id, EmployeeModel employee) throws Exception {
        try {
            Optional<Department> department = departmentRepository.findById(employee.getDepartmentId());
            Optional<Employee> oldEmployee = employeeRepository.findById(id);
            if (oldEmployee.isEmpty()) {
                return false;
            }
            oldEmployee.get().setFullName(employee.getFullName());
            oldEmployee.get().setEmail(employee.getEmail());
            oldEmployee.get().setAddress(employee.getAddress());
            oldEmployee.get().setBirthday(employee.getBirthday());
            oldEmployee.get().setAddress(employee.getAddress());
            oldEmployee.get().setGender(employee.getGender());
            oldEmployee.get().setJobPosition(employee.getJobPosition());
            if (department.isPresent()) {
                oldEmployee.get().setDepartment(department.get());
            }
            oldEmployee.get().setManager(employee.getManager());
            oldEmployee.get().setPassword(employee.getPassword());
            oldEmployee.get().setTaxCode(employee.getTaxCode());

            employeeRepository.save(oldEmployee.get());
            return true;
        } catch (Exception e) {
            throw new Exception("Update Error: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteEmployee(String id) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            if (employee.isEmpty()) {
                return false;
            }
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Delete error: " + e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteManyEmployee(List<String> employeeCode) throws RuntimeException {
        try {
            for (String id : employeeCode) {
                employeeRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting");
        }
    }

    @Override
    public long getCount() throws Exception {
        try {
            return employeeRepository.count();
        } catch (RuntimeException e) {
            throw new RuntimeException("Get count error: " + e.getMessage());
        }
    }

    public Employee mapToEmployee(EmployeeModel employee) {

        return Employee.builder()
                .employeeCode(employee.getEmployeeCode())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .fullName(employee.getFullName())
                .gender(employee.getGender())
                .birthday(employee.getBirthday())
                .manager(employee.getManager())
                .phone(employee.getPhone())
                .address(employee.getAddress())
                .jobPosition(employee.getJobPosition())
                .taxCode(employee.getTaxCode())
                .imagePath(employee.getImagePath())
                .build();
    }
}
