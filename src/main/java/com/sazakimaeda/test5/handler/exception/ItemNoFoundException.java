package com.sazakimaeda.test5.handler.exception;

public class ItemNoFoundException extends RuntimeException{
    public ItemNoFoundException() {
        super("Item no found");
    }
}
