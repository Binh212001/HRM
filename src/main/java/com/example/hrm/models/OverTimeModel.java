package com.example.hrm.models;

import lombok.Data;

@Data
public class OverTimeModel {
    private String id;
    private String employeeCode;
    private String employeeName;
    private String date;
    private String reason;
    private String status;
    private float startTime;
    private float endTime;
    private float actualHours;

    public OverTimeModel(String id, String employeeCode, String date, String reason, String status, String employeeName, float startTime, float endTime, float actualHours) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.date = date;
        this.reason = reason;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.actualHours = actualHours;
        this.employeeName = employeeName;
    }
}
