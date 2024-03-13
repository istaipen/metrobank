package com.test.testing.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler 
{
    //This method get triggered whenever there is MethodArgumentNotValidException exception.
    //It shows only the user friendly error message.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object>handleInvalidArgument(MethodArgumentNotValidException exception)
    {
        Map<String,Object>errorMap=new LinkedHashMap <>();
        StringBuffer sb = new StringBuffer();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            if (sb.length() > 0 ){
                sb.append(" ");
            }
            sb.append(error.getDefaultMessage());
        });
        
        errorMap.put("transactionStatusCode", HttpStatus.BAD_REQUEST.value());
        errorMap.put("transactionStatusDescription", sb.toString());
        return errorMap;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public Map<String,Object>handleUserNotFoundException(CustomerNotFoundException exception)
    {
        Map<String,Object>errorMap=new LinkedHashMap<>();
        errorMap.put("transactionStatusCode", HttpStatus.NOT_FOUND.value());
        errorMap.put("transactionStatusDescription", "Customer not found");

        return errorMap;
    }
}