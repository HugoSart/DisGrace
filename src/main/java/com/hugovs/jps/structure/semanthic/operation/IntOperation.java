package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.structure.semanthic.Type;

public abstract class IntOperation extends Operation {
    public IntOperation() {
        super(Type.INT, Type.INT, Type.INT);
    }
}
