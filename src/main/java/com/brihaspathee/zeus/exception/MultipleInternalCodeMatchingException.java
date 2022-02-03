package com.brihaspathee.zeus.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 3:17 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.exception
 * To change this template use File | Settings | File and Code Template
 */
public class MultipleInternalCodeMatchingException extends RuntimeException{

    public MultipleInternalCodeMatchingException(String message){
        super(message);
    }

    public MultipleInternalCodeMatchingException(String message, Throwable cause){
        super(message, cause);
    }
}
