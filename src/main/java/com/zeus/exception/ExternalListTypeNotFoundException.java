package com.zeus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 1:04 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.exception
 * To change this template use File | Settings | File and Code Template
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExternalListTypeNotFoundException extends RuntimeException {

    public ExternalListTypeNotFoundException(String message){
        super(message);
    }

    public ExternalListTypeNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
