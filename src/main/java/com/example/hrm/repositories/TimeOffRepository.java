package com.example.hrm.repositories;

import com.example.hrm.entity.Attendance;
import com.example.hrm.entity.TimeOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeOffRepository extends JpaRepository<TimeOff, String> {


}
