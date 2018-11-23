package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.exception.IncompatibleTypeException;
import com.hugovs.jps.structure.semanthic.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class Expression extends Value {

    private boolean singleton = false;
    private List<Operation> operations = new ArrayList<>();

    public void addOperation(Operation op) {
        if (op.getType() != getType()) throw new IncompatibleTypeException(getType(), op.getType());
        operations.add(op);
    }

    public void setSingleton(boolean b) {
        this.singleton = b;
    }

    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (Operation op : operations) {
            builder.append(op.toString());
            if (count < operations.size() - 1)
                builder.append(", ");
            count++;
        }
        return getClass().getSimpleName() + "<singleton=" + singleton + ", operations=[" + builder.toString() + "], value=" + getValue() + ">";
    }

}
