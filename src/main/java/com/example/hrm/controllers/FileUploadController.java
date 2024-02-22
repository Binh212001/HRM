package com.example.hrm.controllers;

import com.example.hrm.entity.Employee;
import com.example.hrm.repositories.EmployeeRepository;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(emp.isEmpty()){
            return ResponseEntity.ok(new Response<String>("Cannot find employee "+employeeCode,"OK",400));
        }
        if (file.isEmpty()) {
            return ResponseEntity.ok(new Response<String>("Please select a file to upload ","OK",400));
        }

        try {

            byte[] bytes = file.getBytes();
            String urlPath = "E:\\images\\" + file.getOriginalFilename();
            Path path = Paths.get(urlPath);
            Files.write(path, bytes);
            emp.get().setImagePath(urlPath);
            return ResponseEntity.ok(new Response<String>("File uploaded successfully","OK",200));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new Response<String>("Failed to upload file","OK",200));
        }
    }
}
