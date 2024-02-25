package com.example.hrm.repositories;

import com.example.hrm.entity.Attendance;
import com.example.hrm.models.AttendanceModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Attendance (date, start_time, end_time, status, employee_code) VALUES (:date, 8.0, 17.0, :status, :employeeCode)", nativeQuery = true)
    void saveAttendance(String date, String employeeCode , String status);

    @Query("SELECT new com.example.hrm.models.AttendanceModel(a.attendanceId, a.date, a.startTime, a.endTime, a.status, e.employeeCode,e.fullName) FROM Attendance a INNER JOIN Employee as e on e.employeeCode = a.employee.employeeCode where  a.employee.employeeCode = :employeeCode")
    List<AttendanceModel> findAttendanceByEmployeeCode(String employeeCode);

}
