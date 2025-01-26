package com.aida.request;

import com.aida.domain.USER_ROLE;
import lombok.Data;

@Data
public class LoginOtpRequest {
    private String email;
    private String password;
    private USER_ROLE role;
}
