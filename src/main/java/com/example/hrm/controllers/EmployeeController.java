package com.example.hrm.controllers;

import com.example.hrm.entity.Employee;
import com.example.hrm.models.EmployeeModel;
import com.example.hrm.services.EmployeeService;
import com.example.hrm.utils.Response;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<Response<List<Employee>>> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getEmployees();

            return ResponseEntity.ok(new Response<>(employees,"OK",200));
        }catch (RuntimeException e) {
            return (ResponseEntity<Response<List<Employee>>>) ResponseEntity.badRequest();
        }

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Response<List<Employee>>> getEmployeeByName(@PathVariable String name  ) {
        try {
            List<Employee> employees = employeeService.getEmployeeByName(name);
            return ResponseEntity.ok(new Response<>(employees,"OK",200));
        }catch (RuntimeException e) {
            return (ResponseEntity<Response<List<Employee>>>) ResponseEntity.badRequest();
        }

    }

    @GetMapping("/code/{id}")
    public ResponseEntity<Response<Employee>> getEmployeeById(@PathVariable String id  )  {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if(employee == null) {
                return ResponseEntity.ok(new Response<>(employee,"Cannot find employee",400));
            }
            return ResponseEntity.ok(new Response<>(employee,"OK",200));

        }catch (RuntimeException e) {
            return (ResponseEntity<Response<Employee>>) ResponseEntity.badRequest();
        }

    }
    @PostMapping("/new")
    public ResponseEntity<Response<Employee>> addNewEmployee(@RequestBody EmployeeModel employee) {
        try {
            Employee emp = employeeService.saveEmployee(employee);
            return ResponseEntity.ok(new Response<>(emp,"OK",200));
        }catch (Exception e) {
            return ResponseEntity.ok(new Response<>(null,e.getMessage(),400));
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> addNewEmployee(@PathVariable String id) {
        try {
            boolean success = employeeService.deleteEmployee(id);
            return ResponseEntity.ok(new Response<Boolean>(success,"OK",200));
        }catch (Exception e) {
            return ResponseEntity.ok(new Response<Boolean>(false,e.getMessage(),400));
        }

    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Response<Boolean>> updateEmployee(@PathVariable String id , @RequestBody EmployeeModel employee)  {
        try {
            boolean isSuccess = employeeService.updateEmployee(id, employee);
            if (isSuccess) {
                return ResponseEntity.ok(new Response<Boolean>(isSuccess,"OK",200));
            }
            return ResponseEntity.ok(new Response<Boolean>(isSuccess,"Can not find employee",400));
        }catch (Exception e) {
            return ResponseEntity.ok(new Response<Boolean>(false,e.getMessage(),400));
        }

    }

    @DeleteMapping("/delete/many")
    public  ResponseEntity<Response<Boolean>> deleteMany(List<String> employeeCode){
        try {
            boolean isSuccess =  employeeService.deleteManyEmployee(employeeCode);
            return ResponseEntity.ok(new Response<Boolean>(isSuccess,"OK",200));
        }catch (Exception e) {
            return ResponseEntity.ok(new Response<Boolean>(false,e.getMessage(),400));
        }
    }

}
