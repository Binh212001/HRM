package com.example.hrm.models;

import com.example.hrm.entity.Contract;
import com.example.hrm.entity.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ContractModel {


    private String contractCode;
    private Date dateSign;
    private Date dateEnd;
    private String salaryBasic;
    private String employeeCode;
    private String allowance;
    private String dependentPersonality;
    private String email;

    private String fullName;
    private String gender;
    private String jobPosition;
    private String phone;
    private String address;
    private Date birthday;
    private String taxCode;
    private String imagePath;

    public ContractModel(String contractCode, Date dateSign, Date dateEnd, String salaryBasic, String employeeCode, String allowance, String dependentPersonality, String email,  String fullName,  String jobPosition, String manager, String phone, String address, Date birthday, String taxCode, String imagePath ,String gender) {
        this.contractCode = contractCode;
        this.dateSign = dateSign;
        this.dateEnd = dateEnd;
        this.salaryBasic = salaryBasic;

        this.employeeCode = employeeCode;
        this.allowance = allowance;
        this.dependentPersonality = dependentPersonality;
        this.email = email;

        this.fullName = fullName;
        this.gender = gender;
        this.jobPosition = jobPosition;


        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.taxCode = taxCode;
        this.imagePath = imagePath;
    }
}
