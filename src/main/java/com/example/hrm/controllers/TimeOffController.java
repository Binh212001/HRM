package com.example.hrm.controllers;

import com.example.hrm.models.TimeOffModel;
import com.example.hrm.services.TimeOffService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            timeOffService.newTimeOff(timeOffModel);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(true, "Ok"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<Boolean>(false, e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<TimeOffModel>>> getAllTimeOff(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        try {
            List<TimeOffModel> data = timeOffService.getAllTimeOff(page, limit);
            long count = timeOffService.getCount();
            return ResponseEntity.status(HttpStatus.OK).body(new Response<List<TimeOffModel>>(count, data, "Ok"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }
    }

    @GetMapping("/employee/{empCode}")
    public ResponseEntity<Response<List<TimeOffModel>>> getTimeOffByEmployeeCode(@PathVariable String empCode) {
        try {
            List<TimeOffModel> data = timeOffService.getTimeOffByEmployeeCode(empCode);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<List<TimeOffModel>>(data, "Ok"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));

        }
    }

}
