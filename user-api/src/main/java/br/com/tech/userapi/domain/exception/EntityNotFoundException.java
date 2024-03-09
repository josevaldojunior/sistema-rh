package br.com.tech.userapi.domain.exception;

public class EntityNotFoundException extends NegocioException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
