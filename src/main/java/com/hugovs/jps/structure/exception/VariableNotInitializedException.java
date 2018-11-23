package com.hugovs.jps.structure.exception;

public class VariableNotInitializedException extends RuntimeException {

    public VariableNotInitializedException(String id) {
        super("The variable " + id + " was not initialized.");
    }

}
