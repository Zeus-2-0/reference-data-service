package com.brihaspathee.zeus.web.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 1:32 PM
 * Project: Zeus
 * Package Name: com.zeus.web.response
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMetadata {

    private LocalDateTime timestamp;

    private int statusCode;

    private HttpStatus status;

    private String reason;

    private String message;

    private String developerMessage;

    @Override
    public String toString() {
        return "ResponseMetadata{" +
                "timestamp=" + timestamp +
                ", statusCode=" + statusCode +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", message='" + message + '\'' +
                ", developerMessage='" + developerMessage + '\'' +
                '}';
    }
}
