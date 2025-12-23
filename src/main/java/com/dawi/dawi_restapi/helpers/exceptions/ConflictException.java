package com.dawi.dawi_restapi.helpers.exceptions;

/**
 * Excepción lanzada cuando hay un conflicto de datos.
 * Ejemplo: Habitación ya reservada en esas fechas, email duplicado, etc.
 */
public class ConflictException extends RuntimeException {

    private final String conflictType;

    public ConflictException(String message) {
        super(message);
        this.conflictType = "CONFLICT";
    }

    public ConflictException(String message, String conflictType) {
        super(message);
        this.conflictType = conflictType;
    }

    public String getConflictType() {
        return conflictType;
    }
}
