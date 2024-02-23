package com.example.hrm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeModel {
    private String employeeCode;
    private String email;
    private String password;
    private String fullName;
    private String gender;
    private String jobPosition;
    private String departmentId;
    private String manager;
    private String phone;
    private String address;
    private Date birthday;
    private String taxCode;
    private String imagePath;
}
