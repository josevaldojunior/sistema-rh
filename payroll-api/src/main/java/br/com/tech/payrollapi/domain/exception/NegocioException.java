package br.com.tech.payrollapi.domain.exception;

public class NegocioException extends RuntimeException{
    public NegocioException(String message) {
        super(message);
    }
}
