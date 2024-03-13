package com.example.hrm.services;

import com.example.hrm.models.OverTimeModel;

import java.util.List;

public interface OverTimeService {
    Boolean newOverTime(OverTimeModel overTimeModel) throws Exception;
    List<OverTimeModel> getAllOverTime(int page , int limit) throws Exception;
    List<OverTimeModel> getOvertimeByEmployeeCode(String empCode) throws Exception;
    long getCount() throws Exception;
}
