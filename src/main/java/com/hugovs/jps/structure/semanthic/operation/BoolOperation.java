package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.structure.semanthic.Type;

public abstract class BoolOperation extends Operation {
    public BoolOperation(String llvmCode) {
        super(llvmCode,Type.BOOL, Type.BOOL, Type.BOOL);
    }
}
