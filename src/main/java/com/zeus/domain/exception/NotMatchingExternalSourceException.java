package com.zeus.domain.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 2:40 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.exception
 * To change this template use File | Settings | File and Code Template
 */
public class NotMatchingExternalSourceException extends RuntimeException{

    public NotMatchingExternalSourceException(String message){
        super(message);
    }

    public NotMatchingExternalSourceException(String message, Throwable cause){
        super(message, cause);
    }
}
