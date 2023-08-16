package com.neslisezen.neslifly.exception;


import com.neslisezen.neslifly.dto.BaseResponse;
import com.neslisezen.neslifly.dto.response.AirportSaveResponse;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.MessageFormat;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException
            (NoHandlerFoundException ex,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request)
    {
        final var errorMessage= MessageFormat.format(
                "No handler found for {0} {1}", ex.getHttpMethod(),
                ex.getRequestURL());

        var response = BaseResponse.<AirportSaveResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .success(false)
                .error(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(final Exception ex,
                                            final WebRequest request)
    {
        System.out.println("EXCEPTION : "+ex.getMessage());
        var response = BaseResponse.<AirportSaveResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(ex.getMessage())
                .success(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}
