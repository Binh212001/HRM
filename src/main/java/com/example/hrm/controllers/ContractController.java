package com.example.hrm.controllers;

import com.example.hrm.entity.Contract;
import com.example.hrm.models.ContractModel;
import com.example.hrm.services.ContractService;
import com.example.hrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @GetMapping("/all")
    public ResponseEntity<Response<List<ContractModel>>> getAllContract(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        try {
            List<ContractModel> contracts = contractService.getContracts(page, limit);
            long count = contractService.getCount();
            return ResponseEntity.status(HttpStatus.OK).body(new Response<List<ContractModel>>(count, contracts, "ok"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Response<Boolean>> saveContract(@RequestBody Contract contract) throws Exception {
        try {
            Boolean isSuccess = contractService.saveContract(contract);
            if (isSuccess.equals(true)) {
                return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(isSuccess, "Created"));
            }
            return ResponseEntity.ok(new Response<>(isSuccess, "Employee is already exist"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }

    }

    @PutMapping("/update")
    public ResponseEntity<Response<Boolean>> updateContract(@RequestBody Contract contract) throws Exception {
        try {
            Boolean isSuccess = contractService.updateContract(contract);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(isSuccess, "OK"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }

    }

    @PostMapping("/delete/{contractCode}")
    public ResponseEntity<Response<Boolean>> deleteContract(@PathVariable String contractCode) throws Exception {
        try {
            Boolean isSuccess = contractService.deleteContract(contractCode);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Boolean>(isSuccess, "OK"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }
    }

    @GetMapping("/code/{contractCode}")
    public ResponseEntity<Response<ContractModel>> getMyContract(@PathVariable String contractCode) {
        try {
            ContractModel contracts = contractService.getContract(contractCode);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<ContractModel>(contracts, "OK"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, e.getMessage()));
        }

    }
}
