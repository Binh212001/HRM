package com.example.hrm.services;

import com.example.hrm.models.AttendanceModel;
import com.example.hrm.repositories.AttendanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements  AttendanceService{

    @Autowired
    AttendanceRepository attendanceRepository;


    @Override
    public Boolean createAttendance(String employeeCode) throws Exception {

        try {
            YearMonth currentYearMonth = YearMonth.now();
            int numberOfDays = currentYearMonth.lengthOfMonth();
            int year =LocalDate.now().getYear();
            LocalDate currentDate = LocalDate.now();
            int month = currentDate.getMonthValue();


        for (int i = 1; i <= numberOfDays; i++) {
            LocalDate date  = LocalDate.of(year, month, i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = date.format(formatter);
            attendanceRepository.saveAttendance(formattedDate, employeeCode, "draft");
        }
        return  true;

        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<AttendanceModel> getAttendance(String employeeCode) throws Exception {
        return  attendanceRepository.findAttendanceByEmployeeCode(employeeCode);
    }


}
