package com.shan_infosystem.special_specialized_care.exception.exception;

public class Entity_Not_Found_Exception extends Exception
{
    public Entity_Not_Found_Exception()
    {
        super();
    }

    public Entity_Not_Found_Exception(String message)
    {
        super(message);
    }

    public Entity_Not_Found_Exception(String message , Throwable cause)
    {
        super(message, cause);
    }

    public Entity_Not_Found_Exception(Throwable cause)
    {
        super(cause);
    }
}

