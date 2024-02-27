package com.example.hrm.services;

import com.example.hrm.models.OverTimeModel;
import com.example.hrm.repositories.OverTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OverTimeServiceImpl implements OverTimeService {
    @Autowired
    OverTimeRepository overTimeRepository;
    @Override
    public Boolean newOverTime(OverTimeModel overTimeModel) throws Exception {
        try {
             overTimeRepository.saveOT(overTimeModel.getId() , overTimeModel.getEmployeeCode(),overTimeModel.getDate(),overTimeModel.getReason(),overTimeModel.getStatus(),overTimeModel.getStartTime(),overTimeModel.getEndTime(),overTimeModel.getActualHours());
            return  true;
        }catch (Exception e) {
            throw new Exception("Failed to create");
        }
    }

    @Override
    public List<OverTimeModel> getAllOverTime() throws Exception {
        try {
            return overTimeRepository.getAllOT();
        }catch (Exception e) {
            throw  new RuntimeException("Get error: " + e.getMessage());
        }
    }

    @Override
    public List<OverTimeModel> getOvertimeByEmployeeCode(String empCode) throws Exception {
        return null;
    }
}
