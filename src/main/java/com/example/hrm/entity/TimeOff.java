package com.example.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "timeoff")
@Data
public class TimeOff{

    @Id
    @Column(name = "id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "employee_code")
    private Employee employee;
    @Column(name = "start_date")
    @DateTimeFormat
    private Date startDate;
    @Column(name = "end_date")
    @DateTimeFormat
    private Date endDate;
    @Column(name = "reason")
    private String reason;
    @Column(name = "status")
    private String status;
}
