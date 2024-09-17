package br.com.fullstack.suggestionbox.exceptions;

public abstract class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, Long id) {
        super(entity + " not found with id: " + id);
    }
}
