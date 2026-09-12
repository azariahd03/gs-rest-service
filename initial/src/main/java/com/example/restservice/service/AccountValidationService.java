package com.example.restservice.service;

import com.example.restservice.dto.AccountValidationRequest;
import com.example.restservice.exception.InvalidAccountException;
import org.springframework.stereotype.Service;

@Service
public class AccountValidationService {

    public String validateAccount(AccountValidationRequest request){

        String accountNumber = request.getAccountNumber();
        String ifscCode = request.getIfscCode();

        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new InvalidAccountException(
                    "Account number is required"
            );
        }

        if (!accountNumber.matches("\\d{10,12}")) {
            throw new InvalidAccountException(
                    "Account number must contain 10 to 12 digits"
            );
        }

        if (ifscCode == null || ifscCode.isEmpty()) {
            throw new InvalidAccountException(
                    "IFSC code is required"
            );
        }

        if (!ifscCode.equals("HDFC0001234")) {
            throw new InvalidAccountException(
                    "Invalid IFSC code"
            );
        }
        return  "Account Details are valid";

    }

}
