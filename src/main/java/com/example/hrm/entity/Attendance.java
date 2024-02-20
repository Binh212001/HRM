package com.example.hrm.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    private String date;
    private String startTime;
    private String endTime;
    private String status; // e.g., "Present", "Absent", "Late", etc.
    @ManyToOne
    @JoinColumn(name = "employee_code")
    private Employee employee;
}