package br.unipar.springrest.exceptions;

public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}
