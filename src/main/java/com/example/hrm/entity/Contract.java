package com.example.hrm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
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
    @Column(name = "allowance")
    private String allowance;
    @Column(name = "dependent_personality")
    private String dependentOnPersonality;


}
