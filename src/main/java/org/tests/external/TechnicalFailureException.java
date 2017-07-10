package org.tests.external;

/**
 * Created by GArlington on 09/02/2016.
 */
public class TechnicalFailureException extends Exception {
    public TechnicalFailureException() {
    }

    public TechnicalFailureException(String message) {
        super(message);
    }

    public TechnicalFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalFailureException(Throwable cause) {
        super(cause);
    }

    public TechnicalFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
