package com.example.hrm.controllers;


import com.example.hrm.models.AttendanceModel;
import com.example.hrm.models.EmployeeModel;
import com.example.hrm.services.AttendanceService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attendance")
public class AttendanceController {

    @Autowired
    AttendanceService anAttendanceService;


    @PostMapping("/new/{employeeCode}")
    public ResponseEntity<Response<Boolean>> createAttendance(@PathVariable String employeeCode){
        try {
            boolean success = anAttendanceService.createAttendance(employeeCode);
            return   ResponseEntity.ok(new Response<>(success, "ok", 200));
        }catch (Exception ex){
            return  ResponseEntity.ok(new Response<>(false, "Fail", 400));
        }
    }

    @GetMapping("/employee/{employeeCode}")
    public ResponseEntity<Response<List<AttendanceModel>>> getAttendance(@PathVariable String employeeCode){
        try {
           List<AttendanceModel> attendance = anAttendanceService.getAttendance(employeeCode);
            return   ResponseEntity.ok(new Response<List<AttendanceModel>>(attendance, "ok", 200));
        }catch (Exception ex){
            return  ResponseEntity.ok(new Response<List<AttendanceModel>>(null, "Fail", 400));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Boolean>> updateAttendance(@RequestBody List<AttendanceModel> attendances){
        try {
           String message =  anAttendanceService.updateAttendance(attendances);
            return   ResponseEntity.ok(new Response<>(true, message, 200));
        }catch (Exception e){
            return   ResponseEntity.ok(new Response<Boolean>(false, e.getMessage(), 200));
        }


    }

}
