package com.aida.service;

import com.aida.request.LoginRequest;
import com.aida.response.AuthResponse;
import com.aida.response.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email) throws Exception;
    String createUser(SignupRequest req) throws Exception;
    AuthResponse signing(LoginRequest req);

}
