package com.example.hrm.services;

import com.example.hrm.models.OverTimeModel;
import com.example.hrm.repositories.OverTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverTimeServiceImpl implements OverTimeService {
    @Autowired
    OverTimeRepository overTimeRepository;

    @Override
    public void newOverTime(OverTimeModel overTimeModel) throws Exception {
        try {
            overTimeRepository.saveOT(overTimeModel.getId(), overTimeModel.getEmployeeCode(), overTimeModel.getDate(), overTimeModel.getReason(), overTimeModel.getStatus(), overTimeModel.getStartTime(), overTimeModel.getEndTime(), overTimeModel.getActualHours());
        } catch (Exception e) {
            throw new Exception("Failed to create");
        }
    }


    @Override
    public List<OverTimeModel> getAllOverTime(int page, int limit) throws Exception {
        try {
            Pageable pageable = PageRequest.of(page, limit);
            return overTimeRepository.getAllOT(pageable);

        } catch (Exception e) {
            throw new RuntimeException("Get error: " + e.getMessage());
        }
    }

    @Override
    public List<OverTimeModel> getOvertimeByEmployeeCode(String empCode) throws Exception {
        return null;
    }

    @Override
    public long getCount() throws Exception {
        try {
            return overTimeRepository.count();
        } catch (Exception e) {
            throw new RuntimeException("Error getting count" + e.getMessage());
        }
    }
}
