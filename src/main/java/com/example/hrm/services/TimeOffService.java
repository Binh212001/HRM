package com.example.hrm.services;

import com.example.hrm.models.TimeOffModel;

import java.util.List;

public interface TimeOffService {
    void newTimeOff(TimeOffModel timeOffModel) throws Exception;

    List<TimeOffModel> getAllTimeOff(int page, int limit) throws Exception;

    List<TimeOffModel> getTimeOffByEmployeeCode(String empCode) throws Exception;

    long getCount() throws Exception;
}
