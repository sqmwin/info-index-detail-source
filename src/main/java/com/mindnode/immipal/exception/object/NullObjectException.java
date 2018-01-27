package com.mindnode.immipal.exception.object;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/27
 */
public class NullObjectException extends Exception{
    public NullObjectException() {
        super();
    }

    public NullObjectException(String message) {
        super(message);
    }

    public NullObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullObjectException(Throwable cause) {
        super(cause);
    }

    protected NullObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
