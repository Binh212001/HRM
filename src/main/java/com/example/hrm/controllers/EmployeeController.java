package com.example.hrm.controllers;

import com.example.hrm.entity.Employee;
import com.example.hrm.models.EmployeeModel;
import com.example.hrm.services.EmployeeService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<Response<List<Employee>>> getAllEmployees(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        try {
            List<Employee> employees = employeeService.getEmployees(page, limit);

            long count = employeeService.getCount();

            return ResponseEntity.ok(new Response<>(count, employees, "OK"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Response<List<Employee>>> getEmployeeByName(@PathVariable String name) {
        try {
            List<Employee> employees = employeeService.getEmployeeByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<>(employees, "OK"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, "OK"));

        }

    }

    @GetMapping("/code/{id}")
    public ResponseEntity<Response<Employee>> getEmployeeById(@PathVariable String id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<Employee>(employee, "Cannot find employee"));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Employee>(employee, "OK"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, "OK"));
        }

    }

    @PostMapping("/new")
    public ResponseEntity<Response<Employee>> addNewEmployee(@RequestBody EmployeeModel employee) {
        try {
            Employee emp = employeeService.saveEmployee(employee);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Employee>(emp, "OK"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, "OK"));
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> addNewEmployee(@PathVariable String id) {
        try {
            boolean success = employeeService.deleteEmployee(id);
            if (success) {
                return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(success, "Delete"));
            }
            return ResponseEntity.ok(new Response<>(success, "Cannot find employee"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, "OK"));
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response<Boolean>> updateEmployee(@PathVariable String id, @RequestBody EmployeeModel employee) {
        try {
            boolean isSuccess = employeeService.updateEmployee(id, employee);
            if (isSuccess) {
                return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(isSuccess, "Delete"));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<Boolean>(isSuccess, "Can not find employee" + id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }

    }

    @DeleteMapping("/delete/many")
    public ResponseEntity<Response<Boolean>> deleteMany(List<String> employeeCode) {
        try {
            employeeService.deleteManyEmployee(employeeCode);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(true, "Delete"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(false, "OK"));
        }
    }

}
