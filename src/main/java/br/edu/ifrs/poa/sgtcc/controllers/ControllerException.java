package br.edu.ifrs.poa.sgtcc.controllers;

public class ControllerException extends RuntimeException {
    private static final long serialVersionUID = -6427964537496534459L;

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
