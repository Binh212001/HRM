package com.example.hrm.repositories;

import com.example.hrm.entity.TimeOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeOffRepository extends JpaRepository<TimeOff, String> {
}
