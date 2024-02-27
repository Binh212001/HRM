package com.example.hrm.models;

import lombok.Data;

import java.util.Date;
@Data
public class TimeOffModel {
    private String id;
    private String employeeCode;
    private String date;
    private String reason;
    private String status;
    private String employeeName;

    public TimeOffModel(String id, String employeeCode, String date, String reason, String status, String employeeName) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.date = date;
        this.reason = reason;
        this.status = status;
        this.employeeName = employeeName;
    }
}
