package com.example.hrm.services;

import com.example.hrm.entity.Contract;
import com.example.hrm.entity.Employee;
import com.example.hrm.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> getContracts() throws RuntimeException {
        try {
            return contractRepository.findAll();
        }catch (Exception e) {
          throw  new RuntimeException("Error getting contract" +e.getMessage());
        }
    }

    @Override
    public Optional<Contract> getContract(String code) throws RuntimeException {
        try {
            return contractRepository.findById(code);
        }catch (Exception e) {
            throw  new RuntimeException("Error getting contract" +e.getMessage());
        }
    }

    @Override
    public boolean saveContract(Contract contract) throws Exception {
        try {
            Optional<Contract> oldContract = contractRepository.findById(contract.getContractCode());
            if(oldContract.isEmpty()){
                contractRepository.save(contract);
                return true;
            }
            return false;
        }catch (Exception e) {
            throw  new RuntimeException("Error save contract" +e.getMessage());
        }
    }

    @Override
    public boolean updateContract( Contract contract) throws Exception {
        try {
            Optional<Contract> oldContract = contractRepository.findById(contract.getContractCode());
            if(oldContract.isEmpty()){
                return false;
            }
            oldContract.get().setEmployeeCode(contract.getEmployeeCode());
            oldContract.get().setAllowance(contract.getAllowance());
            oldContract.get().setDependentOnPersonality(contract.getDependentOnPersonality());
            oldContract.get().setDateEnd(contract.getDateEnd());
            oldContract.get().setDateSign(contract.getDateSign());
            oldContract.get().setDependentOnPersonality(contract.getDependentOnPersonality());
            contractRepository.save(oldContract.get());
            return true;
        }catch (Exception e) {
            throw  new RuntimeException("Error updating contract" +e.getMessage());
        }
    }

    @Override
    public boolean deleteContract(String id) throws Exception {
        try {
            Optional<Contract> oldContract = contractRepository.findById(id);
            if(oldContract.isEmpty()){
                return false;
            }
            contractRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            throw  new RuntimeException("Error deleting contract" +e.getMessage());
        }
    }
}
