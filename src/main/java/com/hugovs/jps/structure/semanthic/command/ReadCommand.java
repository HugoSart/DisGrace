package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.llvm.LlvmUtil;
import com.hugovs.jps.structure.semanthic.Type;
import com.hugovs.jps.structure.semanthic.Util;
import com.hugovs.jps.structure.semanthic.Variable;

public class ReadCommand extends Command {

    private Variable variable;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public LlvmIR toIR(int ident) {
        String s = Util.spaces(ident);
        int i = LlvmUtil.tempCount;
        String ir = "";
        ir += s + "%str" + i + " = call " + Type.STRING.llvmCode + " @readString()";
        return new LlvmIR(
                ""
                , "");
    }
}
