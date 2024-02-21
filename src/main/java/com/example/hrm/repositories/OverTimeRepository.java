package com.example.hrm.repositories;

import com.example.hrm.entity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverTimeRepository extends JpaRepository<Overtime, String> {

}
