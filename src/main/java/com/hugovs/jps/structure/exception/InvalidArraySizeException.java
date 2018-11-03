package com.hugovs.jps.structure.exception;

public class InvalidArraySizeException extends RuntimeException {

    public InvalidArraySizeException(int size) {
        super("Invalid array size. Expected: size > 0. Found: " + size);
    }

}
