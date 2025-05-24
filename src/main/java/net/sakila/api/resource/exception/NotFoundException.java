package net.sakila.api.resource.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String entity, int id) {
        super("Could not find " + entity + " " + id);
    }
}
