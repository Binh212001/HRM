package com.example.hrm.repositories;

import com.example.hrm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee , String> {
    List<Employee> findByFullName(String fullName);
    Employee findByEmail(String email);
    @Query(value = "select * from employees limit :limit offset :offset ", nativeQuery = true)
    List<Employee> findAll( int limit ,int offset);
}
