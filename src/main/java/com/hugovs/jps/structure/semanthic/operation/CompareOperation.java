package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.structure.semanthic.Type;

public abstract class CompareOperation extends Operation {

    protected String llvmCode = "";

    public CompareOperation(String llvmCode) {
        super(llvmCode, Type.INT, Type.INT, Type.BOOL);
    }

}
