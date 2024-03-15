package com.example.hrm.controllers;


import com.example.hrm.models.AttendanceModel;
import com.example.hrm.services.AttendanceService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attendance")
public class AttendanceController {

    @Autowired
    AttendanceService anAttendanceService;


    @PostMapping("/new")
    public ResponseEntity<Response<Boolean>> createAttendance(@RequestParam("employeeCode") String employeeCode) throws Exception {
        try {
            anAttendanceService.createAttendance(employeeCode);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>(true, "CREATED"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(false, ex.getMessage()));
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<Response<List<AttendanceModel>>> getAttendance(@RequestParam("employeeCode") String employeeCode) {
        try {
            List<AttendanceModel> attendance = anAttendanceService.getAttendance(employeeCode);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<List<AttendanceModel>>(attendance, "Ok"));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, ex.getMessage()));

        }
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Boolean>> updateAttendance(@RequestBody List<AttendanceModel> attendances) {
        try {
            anAttendanceService.updateAttendance(attendances);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(true, "Updated"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));

        }
    }
}
