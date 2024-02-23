package com.example.hrm.controllers;

import com.example.hrm.entity.Department;
import com.example.hrm.repositories.DepartmentRepository;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public ResponseEntity<Response<List<Department>>> getDepartments(){
        List<Department> departments = departmentRepository.findAll();
        return ResponseEntity.ok(new Response<List<Department>>(departments,"ok",200));
    }



}
