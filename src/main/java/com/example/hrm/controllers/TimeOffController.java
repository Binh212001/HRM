package com.example.hrm.controllers;

import com.example.hrm.models.TimeOffModel;
import com.example.hrm.services.TimeOffService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("time-off/")
public class TimeOffController {
    @Autowired
    TimeOffService timeOffService;

    @PostMapping("/save")
    public ResponseEntity<Response<Boolean>> saveTimeOff(@RequestBody TimeOffModel timeOffModel) {
        try {
            Boolean save = timeOffService.newTimeOff(timeOffModel);
            return ResponseEntity.ok(new Response<>(save, "ok", 200));
        } catch (Exception e) {
            return ResponseEntity.ok(new Response<>(false, e.getMessage(), 400));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<Response<List<TimeOffModel>>> getAllTimeOff() {
        try {
            List<TimeOffModel> data = timeOffService.getAllTimeOff();
            long count = timeOffService.getCount();
            return ResponseEntity.ok(new Response<>(count,data, "ok", 200));
        } catch (Exception e) {
            return ResponseEntity.ok(new Response<>(null, e.getMessage(), 400));
        }
    }
    @GetMapping("/employee/{empCode}")
    public ResponseEntity<Response<List<TimeOffModel>>> getTimeOffByEmployeeCode(@PathVariable String empCode){
        try {
            List<TimeOffModel> data = timeOffService.getTimeOffByEmployeeCode(empCode);
            return ResponseEntity.ok(new Response<>(data, "ok", 200));
        } catch (Exception e) {
            return ResponseEntity.ok(new Response<>(null, e.getMessage(), 400));
        }
    }

}
