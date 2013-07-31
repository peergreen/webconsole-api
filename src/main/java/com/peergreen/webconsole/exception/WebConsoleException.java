package com.peergreen.webconsole.exception;

/**
 * @author Mohammed Boukada
 */
public class WebConsoleException extends Exception {

    public WebConsoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebConsoleException(Exception e) {
        super(e);
    }
}
