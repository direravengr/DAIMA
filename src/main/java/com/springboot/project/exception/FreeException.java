package com.springboot.project.exception;

import com.springboot.project.enums.Status;

public class FreeException extends RuntimeException {

    private static final long serialVersionUID = -2491248906316289990L;

    protected int code;

    public FreeException() {
        super();
        this.code = Status.UNKNOWN_ERROR.getCode();
    }

    public FreeException(int code) {
        super();
        this.code = code;
    }

    public FreeException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
