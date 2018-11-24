package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.exception.IncompatibleTypeException;
import com.hugovs.jps.structure.semanthic.operation.Operation;

public class Expression extends Value {

    private boolean singleton = false;
    private Operation operation;

    public void addOperation(Operation op) {
        if (op.getType() != getType()) throw new IncompatibleTypeException(getType(), op.getType());
        operation = op;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setSingleton(boolean b) {
        this.singleton = b;
    }

    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<singleton=" + singleton + ", operation=" + operation + ", value=" + getValue() + ">";
    }

}
