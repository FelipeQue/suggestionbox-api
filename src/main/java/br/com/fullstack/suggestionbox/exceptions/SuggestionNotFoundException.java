package br.com.fullstack.suggestionbox.exceptions;

public class SuggestionNotFoundException extends NotFoundException {
    public SuggestionNotFoundException(Long id){
        super("Suggestion", id);
    }
}
