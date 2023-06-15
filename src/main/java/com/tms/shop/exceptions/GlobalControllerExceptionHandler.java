package com.tms.shop.exceptions;


import static com.tms.shop.utils.Constants.ERROR_PAGE;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView handlerException(AuthorizationException e) {
        log.error("User is not authorized! Please, try again!");
        ModelAndView model = new ModelAndView(ERROR_PAGE);
        model.addObject("error", e.getMessage());
        return model;
    }
}