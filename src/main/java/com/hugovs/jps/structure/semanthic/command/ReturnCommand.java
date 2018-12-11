package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Type;
import com.hugovs.jps.structure.semanthic.Util;

public class ReturnCommand extends Command {

    private Expression exp;

    public void setExpression(Expression exp) {
        this.exp = exp;
    }

    public Expression getExpression() {
        return exp;
    }

    @Override
    public LlvmIR toIR(int n) {
        String s = Util.spaces(n);
        if (exp.getType() != Type.VOID) {
            LlvmIR rir = exp.toIR(n);
            String ir = s + "; ReturnCommand\n";
            ir += s + rir.code + "\n";
            ir += s + "ret " + exp.getType().llvmCode + " " + rir.result;
            return new LlvmIR(ir, "");
        } else {
            String ir = s + "; ReturnCommand\n";
            return new LlvmIR(ir + s + "ret void", "");
        }
    }
}
