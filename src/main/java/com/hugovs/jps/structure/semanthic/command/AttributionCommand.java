package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Expression;
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
}
