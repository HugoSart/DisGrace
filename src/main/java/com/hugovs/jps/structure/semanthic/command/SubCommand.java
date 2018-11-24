package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Subprogram;

import java.util.List;

public class SubCommand extends Command {
    private Subprogram subprogram;
    private List<Expression> arguments;

    public Subprogram getSubprogram() {
        return subprogram;
    }

    public void setSubprogram(Subprogram subprogram) {
        this.subprogram = subprogram;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }
}
