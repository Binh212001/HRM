package com.example.hrm.services;

import com.example.hrm.entity.Attendance;
import com.example.hrm.entity.Contract;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    List<Attendance> getAttendance() throws RuntimeException;
    List<Attendance> getAttendanceByEmployee(String employeeId) throws RuntimeException;






}
