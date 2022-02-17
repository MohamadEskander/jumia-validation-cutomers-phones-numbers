package com.example.jumiatask.rest.exceptionHandler;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;
}
