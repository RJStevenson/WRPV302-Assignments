package com.wrpv302.a3.boopandroid.BuisnessLogic;

public class Result<T> {
    public T Data;
    public boolean Successful;
    public String Message;

    public Result(T data)
    {
        Data = data;
        Successful = true;
    }

    public Result(boolean b, String message)
    {
        Successful = false;
        Message = message;
    }
}
