package com.zeus.domain.exception;

import com.zeus.web.response.ApiException;
import com.zeus.web.response.ApiExceptionList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 3:17 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.exception
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@ControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(InternalListTypeNotFoundException.class)
    public ResponseEntity<ApiExceptionList> handleListTypeNotFoundException(InternalListTypeNotFoundException exception){
        log.info("Inside the internal list not found exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100001");
        return new ResponseEntity<>(exceptionList, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExternalListTypeNotFoundException.class)
    public ResponseEntity<ApiExceptionList> handleExternalListTypeNotFoundException(ExternalListTypeNotFoundException exception){
        log.info("Inside the external list not found exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100002");
        return new ResponseEntity<>(exceptionList, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCodeException.class)
    public ResponseEntity<ApiExceptionList> handleInvalidCodeFoundException(InvalidCodeException exception){
        log.info("Inside the invalid code exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100003");
        return new ResponseEntity<>(exceptionList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotMatchingExternalSourceException.class)
    public ResponseEntity<ApiExceptionList> handleNotMatchingSourcexception(NotMatchingExternalSourceException exception){
        log.info("Inside the not matching external source exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100004");
        return new ResponseEntity<>(exceptionList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoMatchingInternalRefDataCodeException.class)
    public ResponseEntity<ApiExceptionList> handleNoMatchingInternalRefDataException(NoMatchingInternalRefDataCodeException exception){
        log.info("Inside the no matching internal reference data exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100005");
        return new ResponseEntity<>(exceptionList, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MultipleInternalCodeMatchingException.class)
    public ResponseEntity<ApiExceptionList> handleMultipleMatchingInternalRefDataException(MultipleInternalCodeMatchingException exception){
        log.info("Inside the multiple internal reference data matching exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100006");
        return new ResponseEntity<>(exceptionList, HttpStatus.NOT_FOUND);
    }

    private ApiExceptionList getApiExceptionList(Exception exception, String errorCode) {
        List<ApiException> errors = new ArrayList<>();
        ApiException apiException = ApiException.builder()
                .exceptionCode(errorCode)
                .exceptionMessage(exception.getMessage())
                .build();
        errors.add(apiException);
        ApiExceptionList exceptionList = ApiExceptionList.builder().exceptions(errors).build();
        return exceptionList;
    }
}
