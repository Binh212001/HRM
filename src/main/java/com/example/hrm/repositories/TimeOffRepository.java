package com.example.hrm.repositories;

import com.example.hrm.entity.TimeOff;
import com.example.hrm.models.TimeOffModel;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeOffRepository extends JpaRepository<TimeOff, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into  TimeOff(id,employee_code ,date ,reason , status) values(:id,:employeeCode,:date,:reason,:status)", nativeQuery = true)
    void saveTimeOff(String id, String employeeCode, String date, String reason, String status);

    @Query("SELECT new com.example.hrm.models.TimeOffModel(t.id, e.employeeCode, t.date, t.reason, t.status,e.fullName) FROM TimeOff t INNER JOIN Employee as e on e.employeeCode = t.employee.employeeCode")

    List<TimeOffModel > getAllTimeOff(Pageable pageable);

    @Query("SELECT new com.example.hrm.models.TimeOffModel(t.id, e.employeeCode, t.date, t.reason, t.status,e.fullName) FROM TimeOff t INNER JOIN Employee as e on e.employeeCode = t.employee.employeeCode where t.employee.employeeCode =:employeeCode")

    List<TimeOffModel > getTimeOffByEmployeeCode(String employeeCode);


}
