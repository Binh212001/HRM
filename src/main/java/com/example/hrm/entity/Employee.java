package com.example.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_code")
    private String employeeCode;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "job_position")
    private String jobPosition;
    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "manager")
    private String manager;
    @Column(name = "contract_code")
    private String contract_code;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "tax_code")
    private String taxCode;
}