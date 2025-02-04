package com.aida.exception;

import java.time.LocalDateTime;
import java.util.Objects;

public class ErrorDetails {
    private String error;
    private String details;
    private LocalDateTime timeStamp;

    public ErrorDetails() {}

    public ErrorDetails(String error, String details, LocalDateTime timeStamp) {
        this.error = error;
        this.details = details;
        this.timeStamp = timeStamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDetails that = (ErrorDetails) o;
        return Objects.equals(error, that.error) &&
                Objects.equals(details, that.details) &&
                Objects.equals(timeStamp, that.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, details, timeStamp);
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "error='" + error + '\'' +
                ", details='" + details + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}