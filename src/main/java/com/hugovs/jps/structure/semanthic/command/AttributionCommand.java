package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Util;
import com.hugovs.jps.structure.semanthic.Variable;

public class AttributionCommand extends Command {

    private Expression expression;
    private Variable variable;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public LlvmIR toIR(int ident) {
        String s = Util.spaces(ident);
        LlvmIR exp = expression.toIR(ident);
        LlvmIR var = variable.toIR(ident);
        return new LlvmIR(
                "\n" + s + "; AttributionCommand\n" +
                s + exp.code +
                s + var.result + " = " + exp.result,
                var.result
        );
    }
}
