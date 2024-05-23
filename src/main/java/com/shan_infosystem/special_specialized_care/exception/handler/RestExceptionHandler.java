package com.shan_infosystem.special_specialized_care.exception.handler;

import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.message.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Entity_Not_Found_Exception.class)
    public ResponseEntity<ErrorMessage> Not_Found_Exception(Entity_Not_Found_Exception exception,
                                                            WebRequest request)
    {
        logger.warn( " : -> Error "+ HttpStatus.NOT_FOUND);
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(Entity_Found_Exception.class)
    public ResponseEntity<ErrorMessage> Found_Exception(Entity_Found_Exception exception, WebRequest request)
    {
        logger.warn(""+HttpStatus.FOUND);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new ErrorMessage(HttpStatus.FOUND,exception.getMessage() ));
    }
}
