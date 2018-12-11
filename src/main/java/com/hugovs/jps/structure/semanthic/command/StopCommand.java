package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.exception.GraceException;
import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Block;
import com.hugovs.jps.structure.semanthic.StringReference;
import com.hugovs.jps.structure.semanthic.Util;

public class StopCommand extends Command {
    public StringReference label;

    @Override
    public LlvmIR toIR(int ident) {
        String s = Util.spaces(ident);

        String label = null;
        Block block = this.block;
        do {
            if (block != null) {
                label = block.outLabel.value;
                block = block.getParent();
            }
        } while (label == null && block != null);

        if (label == null)
            throw new GraceException("Stop command not inside a loop");

        return new LlvmIR(
                s + "; StopCommand" + "\n" +
                s + "br label %" + label + "\n", ""
        );
    }
}
