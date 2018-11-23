package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.structure.semanthic.Type;

public abstract class CompareOperation extends Operation {

    public CompareOperation() {
        super(Type.INT, Type.INT, Type.BOOL);
    }

}
