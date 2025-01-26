package com.aida.service;

import com.aida.domain.USER_ROLE;
import com.aida.request.LoginRequest;
import com.aida.response.AuthResponse;
import com.aida.response.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email, USER_ROLE role) throws Exception;
    String createUser(SignupRequest req) throws Exception;
    AuthResponse signing(LoginRequest req);

}
