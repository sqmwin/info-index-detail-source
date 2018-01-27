package com.mindnode.immipal.exception.list;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/27
 */
public class NullListException extends Exception {
    public NullListException() {
        super();
    }

    public NullListException(String message) {
        super(message);
    }

    public NullListException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullListException(Throwable cause) {
        super(cause);
    }

    protected NullListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
