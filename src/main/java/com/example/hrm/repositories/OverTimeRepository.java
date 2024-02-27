package com.example.hrm.repositories;

import com.example.hrm.entity.Overtime;
import com.example.hrm.models.OverTimeModel;
import com.example.hrm.models.TimeOffModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OverTimeRepository extends JpaRepository<Overtime, String> {
    @Modifying
    @Transactional
    @Query(value = "insert into  Overtime(id,employee_code ,date ,reason , status,start_time , end_time, actual_hours) values(:id,:employeeCode,:date,:reason,:status,:startTime,:endTime,:actualHours)", nativeQuery = true)
    void saveOT(String id, String employeeCode, String date, String reason, String status, float startTime, float endTime, float actualHours);
    @Query("SELECT new com.example.hrm.models.OverTimeModel(o.id, e.employeeCode, o.date, o.reason, o.status,e.fullName,o.startTime,o.endTime, o.actualHours) FROM Overtime o INNER JOIN Employee as e on e.employeeCode = o.employee.employeeCode")
    List<OverTimeModel> getAllOT();

}
