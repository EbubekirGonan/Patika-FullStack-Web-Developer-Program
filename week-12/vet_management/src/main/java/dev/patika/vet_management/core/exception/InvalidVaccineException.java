package dev.patika.vet_management.core.exception;

public class InvalidVaccineException extends RuntimeException{
    public InvalidVaccineException(String message) {
        super(message);
    }
}
