package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.llvm.LlvmUtil;
import com.hugovs.jps.structure.semanthic.Type;
import com.hugovs.jps.structure.semanthic.Util;

public abstract class IntOperation extends Operation {

    public IntOperation(String llvmCode) {
        super(llvmCode, Type.INT, Type.INT, Type.INT);
    }

}
