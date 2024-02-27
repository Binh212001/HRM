package com.example.hrm.services;

import com.example.hrm.models.TimeOffModel;

import java.util.List;

public interface TimeOffService {
    Boolean newTimeOff(TimeOffModel timeOffModel) throws Exception;
    List<TimeOffModel> getAllTimeOff() throws Exception;

    List<TimeOffModel> getTimeOffByEmployeeCode(String empCode) throws Exception;
}
