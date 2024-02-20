package com.example.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @Column(name ="department_code")
    private  String departmentCode;
    @Column(name ="department_name")
    private  String departmentName;
    @OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL)
    private List<Employee> employees ;

}
