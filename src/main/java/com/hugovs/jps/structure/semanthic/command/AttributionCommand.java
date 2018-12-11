package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Type;
import com.hugovs.jps.structure.semanthic.Util;
import com.hugovs.jps.structure.semanthic.Variable;

public class AttributionCommand extends Command {

    private Expression expression = null;
    private Variable variable = null;
    public Expression position = null;

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
        if (position != null) {
            LlvmIR pos = position.toIR(ident);
            return new LlvmIR(
                    pos.code +
                    "\n" + s + "; AttributionCommand\n" +
                            s + exp.code +
                            s + "store " + variable.getType().llvmCode + " getelementptr " + variable.getType().llvmCode + " " + exp.result + ", " + Type.INT.llvmCode + "* %" + variable.getId(),
                    ""
            );
        } else if (var != null) {
            return new LlvmIR(
                    "\n" + s + "; AttributionCommand\n" +
                            s + exp.code +
                            s + var.result + " = " + exp.result,
                    var.result
            );
        }
        return new LlvmIR("", "null");
    }
}
