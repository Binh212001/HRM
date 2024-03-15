package com.example.hrm.controllers;

import com.example.hrm.models.OverTimeModel;
import com.example.hrm.services.OverTimeService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/overtime")
public class OvertimeController {
    @Autowired
    OverTimeService overTimeService;

    @PostMapping("/save")
    public ResponseEntity<Response<Boolean>> saveTimeOff(@RequestBody OverTimeModel model) {
        try {
            overTimeService.newOverTime(model);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(true, "Ok"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<Boolean>(false, e.getMessage()));

        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<OverTimeModel>>> getAllTimeOff(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        try {
            List<OverTimeModel> data = overTimeService.getAllOverTime(page, limit);
            long count = overTimeService.getCount();
            return ResponseEntity.status(HttpStatus.OK).body(new Response<List<OverTimeModel>>(count, data, "Ok"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));

        }
    }

}
