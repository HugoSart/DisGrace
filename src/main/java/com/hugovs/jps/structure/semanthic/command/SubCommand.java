package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Subprogram;
import com.hugovs.jps.structure.semanthic.Util;
import com.hugovs.jps.structure.semanthic.Value;

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

    @Override
    public LlvmIR toIR(int ident) {
        String s = Util.spaces(ident);
        String param = "";
        String paramDef = "";

        int i = 0;
        for (Value parameter : arguments) {
            LlvmIR ir = parameter.toIR();
            paramDef += s + ir.code + "\n";
            param += parameter.getType().llvmCode + " " + ir.result;
            if (i < arguments.size() - 1) param += ", ";
            i++;
        }

        return new LlvmIR(
                s + "; SubCommand\n" +
                        paramDef,
                "call " + subprogram.getReturnType().llvmCode + " @" + subprogram.getId() + "(" + param + ")");
    }
}
