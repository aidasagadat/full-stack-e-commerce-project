package com.aida.model;

import lombok.Data;

@Data
public class BankDetails {
    private String accountNumber;
    private String accountholderName;
    private String ifscCode;
}
