package com.example.hrm.services;

import com.example.hrm.entity.Attendance;
import com.example.hrm.entity.Contract;
import com.example.hrm.models.AttendanceModel;
import com.example.hrm.models.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {

    Boolean createAttendance(String employeeCode) throws  Exception;
    List<AttendanceModel> getAttendance(String employeeCode) throws  Exception;
    String updateAttendance(List<AttendanceModel> attendances) throws Exception;
    long getCount( ) throws Exception;
}
