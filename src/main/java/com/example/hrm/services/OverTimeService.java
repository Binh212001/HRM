package com.example.hrm.services;

import com.example.hrm.models.OverTimeModel;
import com.example.hrm.models.TimeOffModel;

import java.util.List;

public interface OverTimeService {
    Boolean newOverTime(OverTimeModel overTimeModel) throws Exception;
    List<OverTimeModel> getAllOverTime() throws Exception;
    List<OverTimeModel> getOvertimeByEmployeeCode(String empCode) throws Exception;
}
