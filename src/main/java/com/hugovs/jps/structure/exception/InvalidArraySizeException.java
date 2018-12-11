package com.hugovs.jps.structure.exception;

public class InvalidArraySizeException extends GraceException {

    public InvalidArraySizeException(int size) {
        super("Invalid array size. Expected: size > 0. Found: " + size);
    }

}
