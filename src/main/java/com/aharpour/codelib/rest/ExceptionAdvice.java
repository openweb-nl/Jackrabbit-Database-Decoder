package com.aharpour.codelib.rest;

import com.aharpour.codelib.vo.ErrorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Senussi on 08/12/2017.
 */
@ControllerAdvice
public class ExceptionAdvice {

    private final Logger log = LoggerFactory.getLogger(org.springframework.web.bind.annotation.ExceptionHandler.class);


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorVO processEntityNotFoundException(EntityNotFoundException exception) {
        return new ErrorVO(HttpStatus.NOT_FOUND.value(), exception.getClass().getName(),
                exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorVO processException(Exception exception) {
        log.error("ERROR", exception);
        return new ErrorVO(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getClass().getName(),
                exception.getMessage());
    }

}
