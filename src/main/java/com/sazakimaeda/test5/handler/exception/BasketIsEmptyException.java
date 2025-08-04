package com.sazakimaeda.test5.handler.exception;

public class BasketIsEmptyException extends RuntimeException {
    public BasketIsEmptyException() {
        super("Your basket is empty");
    }
}
