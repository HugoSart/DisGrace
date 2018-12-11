package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Util;

import java.util.List;

public class WriteCommand extends Command {
    private List<Expression> expressions;

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public LlvmIR toIR(int n) {
        String s = Util.spaces(n);
        String ir = s + "; WriteCommand\n";
        for (Expression expression : expressions) {
            LlvmIR rir = expression.toIR(n);
            ir += s + rir.code;
            ir += s + "call i32 @puts(i8* getelementptr inbounds ([128 x i8], [128 x i8]* " + rir.result + " , i32 0, i32 0))\n";
        }

        return new LlvmIR(ir, "");
    }
}
