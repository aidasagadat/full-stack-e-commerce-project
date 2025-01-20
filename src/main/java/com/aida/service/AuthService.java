package com.aida.service;

import com.aida.response.SignupRequest;

public interface AuthService {

    String createUser(SignupRequest req);

}
