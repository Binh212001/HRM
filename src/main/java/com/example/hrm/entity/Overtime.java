package com.example.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "overtime")
@Data
public class Overtime {
    @Id
    @Column(name = "id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "employee_code")
    private Employee employee;
    @Column(name = "date")
    private String date;
    @Column(name = "start_time")
    private float startTime;
    @Column(name = "end_time")
    private float endTime;
    @Column(name = "actual_hours")
    private float actualHours;
    @Column(name = "reason")
    private String reason;
    @Column(name = "status")
    private String status;
}
