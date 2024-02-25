package com.example.hrm.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;
    @Column(name = "date")
    private String date;
    @Column(name = "start_time")
    private float startTime;
    @Column(name = "end_time")
    private float endTime;
    private String status; // e.g., "Present", "Absent", "Late", etc.
    @ManyToOne
    @JoinColumn(name = "employee_code")
    private Employee employee;
}