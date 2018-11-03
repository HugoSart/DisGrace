package com.hugovs.jps.structure.exception;

/**
 * User: hugo_<br/>
 * Date: 15/10/2018<br/>
 * Time: 10:31<br/>
 */
public class DuplicatedIdentifierException extends RuntimeException {

    public DuplicatedIdentifierException() {
        super("Attempt to declare an already declared identifier");
    }

    public DuplicatedIdentifierException(String id) {
        super("Attempt to declare an already declared identifier: " + id);
    }
}
