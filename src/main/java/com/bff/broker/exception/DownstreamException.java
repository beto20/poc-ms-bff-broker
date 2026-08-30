package com.bff.broker.exception;

import org.springframework.http.HttpStatusCode;

/**
 * Wraps an error returned by the downstream business-broker service so the
 * original status and message can be relayed back to the caller.
 */
public class DownstreamException extends RuntimeException {

    private final HttpStatusCode status;

    public DownstreamException(HttpStatusCode status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatusCode getStatus() {
        return status;
    }
}
