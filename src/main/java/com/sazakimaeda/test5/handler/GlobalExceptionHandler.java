package com.sazakimaeda.test5.handler;

import com.sazakimaeda.test5.handler.exception.BasketIsEmptyException;
import com.sazakimaeda.test5.handler.exception.ItemNoFoundException;
import com.sazakimaeda.test5.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseStatusException handleException(Exception e) {
        return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(BasketIsEmptyException.class)
    public ResponseStatusException handleBasketIsEmptyException(BasketIsEmptyException e) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ItemNoFoundException.class)
    public ResponseStatusException handleItemNoFoundException(ItemNoFoundException e) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
