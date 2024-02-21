package com.example.hrm.repositories;

import com.example.hrm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee , String> {
    List<Employee> findByFullName(String fullName);
    Employee findByEmail(String email);
    Boolean deleteByEmployeeCode(String code);
}
