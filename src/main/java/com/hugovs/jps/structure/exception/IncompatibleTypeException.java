package com.hugovs.jps.structure.exception;

import com.hugovs.jps.structure.semanthic.Type;

public class IncompatibleTypeException extends RuntimeException {

    public IncompatibleTypeException() {
        super();
    }

    public IncompatibleTypeException(String msg) {
        super(msg);
    }

    public IncompatibleTypeException(Type t1, Type t2) {
        super("Incompatible type of expression in return. Expected: "
                + t1.name() + ". Found: " + t2.name());
    }

}
