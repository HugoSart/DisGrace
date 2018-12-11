package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Block;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Util;

import java.io.File;
import java.io.FileOutputStream;

public class IfCommand extends Command {

    private static int ifCountGlobal = 0;
    private int ifCount = 0;

    private Expression expression;
    private ElseCommand elseCommand;

    private Block block;

    public IfCommand() {
        ifCount = ifCountGlobal;
        ifCountGlobal++;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ElseCommand getElseCommand() {
        return elseCommand;
    }

    public void setElseCommand(ElseCommand elseCommand) {
        this.elseCommand = elseCommand;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public LlvmIR toIR(int n) {
        String s = Util.spaces(n);
        int r = 0;
        String ir = s + "; IfCommand\n";
        LlvmIR rir = expression.toIR(n);
        ir += s + rir.code;
        ir += s + "%ifcond" + (r=ifCount) + " = " + rir.result + "\n";
        ir += s + "br i1 %ifcond"+ r + ", label %then" + r + ", label " + (elseCommand == null ? "%ifcont" + r : "%else" + r) + "\n";
        ir += s + "then" + r + ":\n";
        ir += block.toIR(n) + "\n";
        ir += s + "br i1 label %ifcont" + r + "\n";

        if (elseCommand != null) {
            ir += s + "else:\n";
            ir += elseCommand.getBlock() == null ? elseCommand.getIfCommand().toIR(n) : elseCommand.getBlock().toIR(n) + "\n";
            ir += s + "br label %ifcont"+ r + "\n";
        }

        ir += s + "ifcont" + r + ":\n";


        return new LlvmIR(ir, "");
    }
}
