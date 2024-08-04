package com.sachin.controller;

class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    UserNotFoundException(String msg) {
        super(msg);
    }
}
