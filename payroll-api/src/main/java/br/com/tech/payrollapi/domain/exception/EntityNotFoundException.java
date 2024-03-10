package br.com.tech.payrollapi.domain.exception;

public class EntityNotFoundException extends NegocioException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
