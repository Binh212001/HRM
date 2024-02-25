package com.example.hrm.models;

import lombok.Data;

import java.util.Date;

@Data
public class AttendanceModel {
    private Long attendanceId;
    private String date;
    private float startTime;
    private float endTime;
    private String status;
    private String employeeCode;

    private  String employeeName;

    public AttendanceModel(Long attendanceId, String date, float startTime, float endTime, String status, String employeeCode, String employeeName  ) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
    }


}
