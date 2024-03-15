package com.example.hrm.controllers;

import com.example.hrm.entity.Employee;
import com.example.hrm.repositories.EmployeeRepository;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class FileUploadController {


    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("employee/upload")
    public ResponseEntity<Response<String>> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("employeeCode") String employeeCode) {

        Optional<Employee> emp = employeeRepository.findById(employeeCode);
        if (emp.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<String>("Cannot find employee " + employeeCode, "Failed"));
        }
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<String>("Please select a file to upload ", "Failed"));
        }

        try {

            byte[] bytes = file.getBytes();
            String urlPath = "E:\\images\\" + file.getOriginalFilename();
            Path path = Paths.get(urlPath);
            Files.write(path, bytes);
            emp.get().setImagePath(urlPath);
            employeeRepository.save(emp.get());
            return ResponseEntity.status(HttpStatus.OK).body(new Response<String>("Ok ", "Success"));

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>("Failed to upload file", e.getMessage()));
        }
    }
}
