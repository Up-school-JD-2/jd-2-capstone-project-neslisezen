package com.neslisezen.neslifly.exception;

public class NoSuchAirportException extends RuntimeException
{
    public NoSuchAirportException (String message)
    {
        super(message);
    }
}
