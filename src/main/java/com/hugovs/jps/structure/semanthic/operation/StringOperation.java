package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.structure.semanthic.Type;

public abstract class StringOperation extends Operation {

    public StringOperation() {
        super(Type.STRING, Type.STRING, Type.STRING);
    }

}
