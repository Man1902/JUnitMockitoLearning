package com.learning.powermockito;

public class CustomException extends Exception {
    public CustomException() {
        super();
    }

    public CustomException(String msg) {
        super(msg);
        System.out.println("CustomException with String arg constructor invoked");
    }
}
