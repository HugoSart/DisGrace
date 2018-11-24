package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Variable;

public class ReadCommand extends Command {

    private Variable variable;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}
