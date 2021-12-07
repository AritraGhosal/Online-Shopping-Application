package com.cg.onlineshopping_application.exception;

public class ValidateProductException extends RuntimeException{

private static final long serialVersionUID = 1L;

public ValidateProductException() {
    super();

}

public ValidateProductException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

}


public ValidateProductException(String message, Throwable cause) {
    super(message, cause);

}

public ValidateProductException(String message) {
    super(message);

}

public ValidateProductException(Throwable cause) {
    super(cause);

}


}
