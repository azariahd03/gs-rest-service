package com.example.restservice.service;

import com.example.restservice.dto.AccountValidationRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountValidationService {

    public String validateAccount(AccountValidationRequest request){
        if(request.getAccountNumber() == null || request.getAccountNumber().isEmpty()){
            return "Invalid: Account number is required";
        }
        if (request.getIfscCode() == null ||
                request.getIfscCode().isEmpty()) {
            return "Invalid: IFSC code is required";
        }
        return  "Account Details are valid";

    }


}
