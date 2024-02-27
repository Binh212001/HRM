package com.example.hrm.services;

import com.example.hrm.models.TimeOffModel;
import com.example.hrm.repositories.TimeOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeOffServiceImpl implements TimeOffService {

    @Autowired
    TimeOffRepository timeOffRepository;
    @Override
    public Boolean newTimeOff(TimeOffModel timeOffModel) throws Exception {
      try {
          timeOffRepository.saveTimeOff(timeOffModel.getId() , timeOffModel.getEmployeeCode(),timeOffModel.getDate(), timeOffModel.getReason(),timeOffModel.getReason());
          return  true;
      }catch (Exception e) {
          throw new Exception("Failed to create");
      }
    }

    @Override
    public List<TimeOffModel> getAllTimeOff() throws Exception {
        try {
            return timeOffRepository.getAllTimeOff();
        }catch (Exception e) {
            throw  new RuntimeException("Get error: " + e.getMessage());
        }
    }
    @Override
    public List<TimeOffModel> getTimeOffByEmployeeCode(String empCode) throws Exception {
        try {
            return timeOffRepository.getTimeOffByEmployeeCode(empCode);
        }catch (Exception e) {
            throw  new RuntimeException("Get error: " + e.getMessage());
        }
    }
}