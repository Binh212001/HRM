package com.example.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "timeoff")
@Data
public class Overtime {
    @Id
    @Column(name = "id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "employee_code")
    private Employee employee;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "reason")
    private String reason;
    @Column(name = "status")
    private String status;
}
