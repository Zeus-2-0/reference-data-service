package com.zeus.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 08, January 2022
 * Time: 8:19 AM
 * Project: Zeus
 * Package Name: com.zeus.exception
 * To change this template use File | Settings | File and Code Template
 */
public class ExternalSourceNotFoundException extends RuntimeException{

    public ExternalSourceNotFoundException(String message){
        super(message);
    }

    public ExternalSourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
