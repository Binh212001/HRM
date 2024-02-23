package com.example.hrm.repositories;

import com.example.hrm.entity.Contract;
import com.example.hrm.models.ContractModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
    @Query("SELECT new com.example.hrm.models.ContractModel(c.contractCode ,c.dateSign,c.dateEnd,c.salaryBasic, c.employeeCode, c.allowance,c.dependentOnPersonality,e.email,e.fullName,e.gender,e.jobPosition,e.department.departmentName,e.phone,e.address,e.birthday,e.taxCode,e.imagePath) FROM  Contract as c  join  Employee as e on c.employeeCode = e.employeeCode")
    List<ContractModel> findAllContracts();


    @Query("SELECT new com.example.hrm.models.ContractModel(c.contractCode ,c.dateSign,c.dateEnd,c.salaryBasic, c.employeeCode, c.allowance,c.dependentOnPersonality,e.email,e.fullName,e.gender,e.jobPosition,e.department.departmentName,e.phone,e.address,e.birthday,e.taxCode,e.imagePath) FROM  Contract as c  join  Employee as e on c.employeeCode = e.employeeCode where c.contractCode = :code")
    Optional<ContractModel> findByContract(String code);
}
