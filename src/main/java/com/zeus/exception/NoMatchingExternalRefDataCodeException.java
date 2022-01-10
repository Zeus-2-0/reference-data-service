package com.zeus.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 08, January 2022
 * Time: 9:55 AM
 * Project: Zeus
 * Package Name: com.zeus.exception
 * To change this template use File | Settings | File and Code Template
 */
public class NoMatchingExternalRefDataCodeException extends RuntimeException{

    public NoMatchingExternalRefDataCodeException(String message){
        super(message);
    }

    public NoMatchingExternalRefDataCodeException(String message, Throwable cause){
        super(message, cause);
    }
}
