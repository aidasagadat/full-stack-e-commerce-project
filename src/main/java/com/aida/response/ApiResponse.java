package com.aida.response;

import java.util.Objects;

public class ApiResponse {
    private String message;

    // Getter
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }

    // Override toString method
    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                '}';
    }

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse that = (ApiResponse) o;
        return Objects.equals(message, that.message);
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
