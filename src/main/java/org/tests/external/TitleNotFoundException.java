package org.tests.external;

/**
 * Created by GArlington on 09/02/2016.
 */
public class TitleNotFoundException extends Exception {
    public TitleNotFoundException() {
    }

    public TitleNotFoundException(String message) {
        super(message);
    }

    public TitleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TitleNotFoundException(Throwable cause) {
        super(cause);
    }

    public TitleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
