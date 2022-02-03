package com.brihaspathee.zeus.exception;

import com.brihaspathee.zeus.web.response.ApiException;
import com.brihaspathee.zeus.web.response.ApiExceptionList;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
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
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleListTypeNotFoundException(InternalListTypeNotFoundException exception){
        log.info("Inside the internal list not found exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100001");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(ExternalListTypeNotFoundException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleExternalListTypeNotFoundException(ExternalListTypeNotFoundException exception){
        log.info("Inside the external list not found exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100002");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCodeException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleInvalidCodeFoundException(InvalidCodeException exception){
        log.info("Inside the invalid code exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100003");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotMatchingExternalSourceException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleNotMatchingSourceException(NotMatchingExternalSourceException exception){
        log.info("Inside the not matching external source exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100004");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(NoMatchingInternalRefDataCodeException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleNoMatchingInternalRefDataException(NoMatchingInternalRefDataCodeException exception){
        log.info("Inside the no matching internal reference data exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100005");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MultipleInternalCodeMatchingException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleMultipleMatchingInternalRefDataException(MultipleInternalCodeMatchingException exception){
        log.info("Inside the multiple internal reference data matching exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100006");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExternalSourceNotFoundException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleExternalSourceNotFoundException(ExternalSourceNotFoundException exception){
        log.info("Inside the external source not found exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100007");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoMatchingExternalRefDataCodeException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleNoMatchingInternalRefDataException(NoMatchingExternalRefDataCodeException exception){
        log.info("Inside the no matching external reference data exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100008");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MultipleExternalCodeMatchingException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleMultipleMatchingExternalRefDataException(MultipleExternalCodeMatchingException exception){
        log.info("Inside the multiple internal reference data matching exception handler");
        ApiExceptionList exceptionList = getApiExceptionList(exception, "100009");
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleBindViolations(BindException exception){
        log.info("Inside the bind exception handler...");
        List<ApiException> errors = new ArrayList<>(exception.getAllErrors().size());
        exception.getAllErrors().forEach(error -> {
            ApiException apiException = ApiException.builder()
                    .exceptionCode(error.getCode())
                    .exceptionMessage(error.getDefaultMessage())
                    .build();
            errors.add(apiException);
        });
        ApiExceptionList exceptionList = ApiExceptionList.builder().exceptions(errors).build();
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ZeusApiResponse<ApiExceptionList>> handleConstraintViolations(ConstraintViolationException exception){
        log.info("Inside the exception handler");
        List<ApiException> errors = new ArrayList<>(exception.getConstraintViolations().size());
        exception.getConstraintViolations().forEach(constraintViolation -> {
            ApiException apiException = ApiException.builder()
                    .exceptionCode(constraintViolation.getPropertyPath().toString())
                    .exceptionMessage(constraintViolation.getMessage())
                    .build();
            errors.add(apiException);
        });
        ApiExceptionList exceptionList = ApiExceptionList.builder().exceptions(errors).build();
        ZeusApiResponse<ApiExceptionList> apiResponse = getExceptionResponse(exceptionList);
        return ResponseEntity.badRequest().body(apiResponse);
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

    private ZeusApiResponse<ApiExceptionList> getExceptionResponse(ApiExceptionList exceptionList) {
        ZeusApiResponse<ApiExceptionList> apiResponse = ZeusApiResponse.<ApiExceptionList>builder()
                .response(exceptionList)
                .message("Failure")
                .build();
        return apiResponse;
    }
}
