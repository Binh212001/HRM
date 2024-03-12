package com.example.hrm.controllers;

import com.example.hrm.entity.Contract;
import com.example.hrm.entity.Employee;
import com.example.hrm.models.ContractModel;
import com.example.hrm.services.ContractService;
import com.example.hrm.services.EmployeeService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @GetMapping("/all")
    public ResponseEntity<Response<List<ContractModel>>> getAllContract() {
        try {
            List<ContractModel>  contracts = contractService.getContracts();
            long count = contractService.getCount();
             return ResponseEntity.ok(new Response<>(count,contracts, "ok", 200));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Response<Boolean>> saveContract(@RequestBody Contract contract) throws Exception {
        Boolean isSuccess = contractService.saveContract(contract);
        return ResponseEntity.ok(new Response<>(isSuccess, "ok", 200));
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Boolean>> updateContract(@RequestBody Contract contract) throws Exception {
        Boolean isSuccess = contractService.updateContract(contract);
        return ResponseEntity.ok(new Response<>(isSuccess, "ok", 200));
    }

    @PostMapping("/delete/{contractCode}")
    public ResponseEntity<Response<Boolean>> deleteContract(@PathVariable String contractCode) throws Exception {
        Boolean isSuccess = contractService.deleteContract(contractCode);
        return ResponseEntity.ok(new Response<>(isSuccess, "ok", 200));
    }

    @GetMapping("/code/{contractCode}")
    public ResponseEntity<Response<ContractModel>> getMyContract(@PathVariable String contractCode) {
        try {
            ContractModel contracts = contractService.getContract(contractCode);
            return ResponseEntity.ok(new Response<>(contracts, "ok", 200));
        } catch (Exception e) {
            return ResponseEntity.ok(new Response<>(null, "Cannot find contract", 400));
        }

    }
}
