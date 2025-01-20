package com.aida.response;

import com.aida.domain.USER_ROLE;

public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;

    public AuthResponse() {
    }

    public AuthResponse(String jwt, String message, USER_ROLE role) {
        this.jwt = jwt;
        this.message = message;
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }
}
