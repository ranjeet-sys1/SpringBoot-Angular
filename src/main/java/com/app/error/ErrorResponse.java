package com.app.error;

import java.util.Date;

public class ErrorResponse {
    private String message;
    private Date timeStamp;
    private String status;
    private Integer statusCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, Date timeStamp, String status, Integer statusCode) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.status = status;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
