package com.ultimatechat.exceptions;

import java.io.IOException;

public class CreateUserException extends IOException {
    public CreateUserException() { }

    public CreateUserException(String message) {
        super(message);
    }

    public CreateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateUserException(Throwable cause) {
        super(cause);
    }
}
