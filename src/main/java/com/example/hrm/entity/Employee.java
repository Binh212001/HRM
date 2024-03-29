package com.example.hrm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "employees")
@Builder
public class Employee {
    @Id
    @Column(name = "employee_code")
    private String employeeCode;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "job_position")
    private String jobPosition;
    @ManyToOne
    @JoinColumn(name = "department_code")
    private Department department;
    @Column(name = "manager")
    private String manager;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    @DateTimeFormat
    private Date birthday;
    @Column(name = "tax_code")
    private String taxCode;
    @Column(name = "image-path")
    private String imagePath;
}