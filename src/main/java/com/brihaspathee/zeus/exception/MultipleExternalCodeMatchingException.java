package com.brihaspathee.zeus.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 08, January 2022
 * Time: 9:57 AM
 * Project: Zeus
 * Package Name: com.zeus.exception
 * To change this template use File | Settings | File and Code Template
 */
public class MultipleExternalCodeMatchingException extends RuntimeException{

    public MultipleExternalCodeMatchingException(String message){
        super(message);
    }

    public MultipleExternalCodeMatchingException(String message, Throwable cause){
        super(message, cause);
    }
}
