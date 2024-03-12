package com.example.hrm.services;

import com.example.hrm.entity.Contract;
import com.example.hrm.entity.Employee;
import com.example.hrm.models.ContractModel;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<ContractModel> getContracts() throws Exception;
    ContractModel getContract(String code) throws Exception;
    boolean saveContract(Contract contract) throws Exception;
    boolean updateContract( Contract contract) throws Exception;
    boolean deleteContract(String id ) throws Exception;
    long getCount( ) throws Exception;

}
