package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Expression;

import java.util.List;

public class WriteCommand extends Command {
    private List<Expression> expressions;

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
}
