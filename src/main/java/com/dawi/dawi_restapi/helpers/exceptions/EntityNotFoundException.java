package com.dawi.dawi_restapi.helpers.exceptions;

/**
 * Excepción lanzada cuando una entidad no es encontrada en la base de datos.
 * Ejemplo: Hotel no encontrado, Reserva no encontrada, etc.
 */
public class EntityNotFoundException extends RuntimeException {

    private final String entityName;
    private final Object identifier;

    public EntityNotFoundException(String entityName, Object identifier) {
        super(String.format("%s con identificador '%s' no fue encontrado", entityName, identifier));
        this.entityName = entityName;
        this.identifier = identifier;
    }

    public EntityNotFoundException(String message) {
        super(message);
        this.entityName = null;
        this.identifier = null;
    }

    public String getEntityName() {
        return entityName;
    }

    public Object getIdentifier() {
        return identifier;
    }
}
