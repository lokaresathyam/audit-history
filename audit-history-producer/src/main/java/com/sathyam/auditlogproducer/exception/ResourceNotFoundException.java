package com.sathyam.auditlogproducer.exception;

public class ResourceNotFoundException extends Exception {
    private String message;
    public ResourceNotFoundException(String message) {
        super();
        this.message = message;
    }
}
