package com.shan_infosystem.special_specialized_care.exception.exception;

public class Expectation_Failed extends Exception
{
    public Expectation_Failed()
    {
        super();
    }

    public Expectation_Failed(String message)
    {
        super(message);
    }

    public Expectation_Failed(String message, Throwable cause)
    {
        super(message, cause);
    }

    public Expectation_Failed(Throwable cause)
    {
        super(cause);
    }
}