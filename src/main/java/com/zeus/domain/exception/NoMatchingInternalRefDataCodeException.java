package com.zeus.domain.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 3:05 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.exception
 * To change this template use File | Settings | File and Code Template
 */
public class NoMatchingInternalRefDataCodeException extends RuntimeException{

    public NoMatchingInternalRefDataCodeException(String message){
        super(message);
    }

    public NoMatchingInternalRefDataCodeException(String message, Throwable cause){
        super(message, cause);
    }
}
