package com.brihaspathee.zeus.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 1:21 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.exception
 * To change this template use File | Settings | File and Code Template
 */
public class InvalidCodeException extends RuntimeException{

    public InvalidCodeException(String message){
        super(message);
    }

    public InvalidCodeException(String message, Throwable cause){
        super(message, cause);
    }
}
