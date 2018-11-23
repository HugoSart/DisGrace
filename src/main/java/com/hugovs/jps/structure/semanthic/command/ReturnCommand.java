package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Expression;

public class ReturnCommand extends Command {

    private Expression exp;

    public void setExpression(Expression exp) {
        this.exp = exp;
    }

    public Expression getExpression() {
        return exp;
    }

}
