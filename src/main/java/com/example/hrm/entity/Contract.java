package com.example.hrm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "contract")
public class Contract {
    @Id
    @Column(name = "contract_code")
    private String contractCode;
    @Column(name = "date_sign")
    @DateTimeFormat
    private Date dateSign;
    @Column(name = "date_end")
    @DateTimeFormat
    private Date dateEnd;
    @Column(name = "salary_basic")
    private String salaryBasic;
    @Column(name = "employee_code")
    private String employeeCode;
    @Column(name = "allowance")
    private String allowance;
    @Column(name = "dependent_personality")
    private String dependentOnPersonality;


}
