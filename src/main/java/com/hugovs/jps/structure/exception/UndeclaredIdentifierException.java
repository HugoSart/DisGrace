package com.hugovs.jps.structure.exception;

/**
 * User: hugo_<br/>
 * Date: 15/10/2018<br/>
 * Time: 10:34<br/>
 */
public class UndeclaredIdentifierException extends GraceException {

    public UndeclaredIdentifierException() {
        super("Reference found to an unknown identifier");
    }

    public UndeclaredIdentifierException(String message) {
        super(message);
    }
}
