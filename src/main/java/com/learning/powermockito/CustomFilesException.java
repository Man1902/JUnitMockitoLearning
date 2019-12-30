package com.learning.powermockito;

public class CustomFilesException extends Exception {
    public CustomFilesException() {
        super();
    }

    public CustomFilesException(String msg) {
        super(msg);
        System.out.println("CustomFilesException with String arg constructor invoked");
    }
}
