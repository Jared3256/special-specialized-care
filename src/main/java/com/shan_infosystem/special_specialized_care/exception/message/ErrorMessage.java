package com.shan_infosystem.special_specialized_care.exception.message;

import org.springframework.http.HttpStatus;


public class ErrorMessage
{
    private HttpStatus status;
    private String message;

    public ErrorMessage(HttpStatus status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus()
    {
        return status;
    }

    public void setStatus(HttpStatus status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;


    }
}
