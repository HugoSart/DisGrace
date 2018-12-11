package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.StringReference;
import com.hugovs.jps.structure.semanthic.Util;

public class SkipCommand extends Command {
    public StringReference label;

    @Override
    public LlvmIR toIR(int ident) {
        String s = Util.spaces(ident);
        return new LlvmIR(
                s + "; SkipCommand" + "\n" +
            s + "br label %" + label.value + "\n", ""
        );
    }
}
