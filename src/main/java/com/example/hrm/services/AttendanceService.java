package com.example.hrm.services;

import com.example.hrm.models.AttendanceModel;

import java.util.List;

public interface AttendanceService {

    void createAttendance(String employeeCode) throws Exception;

    List<AttendanceModel> getAttendance(String employeeCode) throws Exception;

    void updateAttendance(List<AttendanceModel> attendances) throws Exception;

    long getCount() throws Exception;
}
