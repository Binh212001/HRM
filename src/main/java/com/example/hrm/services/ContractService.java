package com.example.hrm.services;

import com.example.hrm.entity.Contract;
import com.example.hrm.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<Contract> getContracts() throws RuntimeException;
    Optional<Contract> getContract(String code) throws RuntimeException;
    boolean saveContract(Contract contract) throws Exception;
    boolean updateContract( Contract contract) throws Exception;
    boolean deleteContract(String id ) throws Exception;

}
