package com.example.hrm.controllers;

import com.example.hrm.models.OverTimeModel;
import com.example.hrm.services.OverTimeService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
            Boolean save = overTimeService.newOverTime(model);
            return ResponseEntity.ok(new Response<>(save, "ok", 200));
        } catch (Exception e) {
            return ResponseEntity.ok(new Response<>(false, e.getMessage(), 400));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<OverTimeModel>>> getAllTimeOff(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        try {
            List<OverTimeModel> data = overTimeService.getAllOverTime(page, limit);
            long count = overTimeService.getCount();
            return ResponseEntity.ok(new Response<>(count,data, "ok", 200));
        } catch (Exception e) {
            return ResponseEntity.ok(new Response<>(null, e.getMessage(), 400));
        }
    }

}
