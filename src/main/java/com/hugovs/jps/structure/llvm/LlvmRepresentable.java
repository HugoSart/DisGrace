package com.hugovs.jps.structure.llvm;

import com.hugovs.jps.structure.semanthic.Util;

public interface LlvmRepresentable {

    default LlvmIR toIR(int ident) {return new LlvmIR(Util.spaces(ident) + "", "");}

    default LlvmIR toIR() {return toIR(0); }

}
