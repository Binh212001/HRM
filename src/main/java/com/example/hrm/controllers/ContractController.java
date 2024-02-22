package com.example.hrm.controllers;

import com.example.hrm.entity.Contract;
import com.example.hrm.entity.Employee;
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
    public ResponseEntity<Response<List<Contract>>> getAllContract() {
        List<Contract> contracts = contractService.getContracts();
        return ResponseEntity.ok(new Response<>(contracts ,"ok",200));
    }

    @PostMapping("/save")
    public ResponseEntity<Response<Boolean>> saveContract(@RequestBody Contract contract) throws Exception {
        Boolean   isSuccess = contractService.saveContract(contract);
        return ResponseEntity.ok(new Response<>(isSuccess,"ok",200));
    }
    @PutMapping("/update")
    public ResponseEntity<Response<Boolean>> updateContract(@RequestBody Contract contract) throws Exception {
        Boolean   isSuccess = contractService.updateContract(contract);
        return ResponseEntity.ok(new Response<>(isSuccess,"ok",200));
    }

    @PostMapping("/delete/{contractCode}")
    public ResponseEntity<Response<Boolean>> deleteContract(@PathVariable String contractCode) throws Exception {
        Boolean   isSuccess = contractService.deleteContract(contractCode);
        return ResponseEntity.ok(new Response<>(isSuccess,"ok",200));
    }

    @GetMapping("/code/{contractCode}")
    public ResponseEntity<Response<Contract>> getMyContract(@PathVariable String contractCode) {
        Optional<Contract> contracts = contractService.getContract(contractCode);
        if(contracts.isEmpty()) {
            return ResponseEntity.ok(new Response<>(contracts.get() ,"Cannot find contract",400));
        }
        return ResponseEntity.ok(new Response<>(contracts.get() ,"ok",200));
    }
}
