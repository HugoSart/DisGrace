package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Block;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Util;

public class WhileCommand extends Command {

    private static int whileCountGlobal = 0;
    private int whileCount = 0;

    public WhileCommand() {
        whileCount = ++whileCountGlobal;
    }

    private Expression expression;
    private Block block;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public LlvmIR toIR(int n) {

        block.inLabel.value = "while" + whileCount;
        block.outLabel.value = "whileout" + whileCount;

        String s = Util.spaces(n);
        String ir = "\n" + s + "; WhileCommand\n";
        ir += s + "while" + whileCount + ":\n";
        LlvmIR rir = expression.toIR(n + 4);
        ir += rir;
        ir += s + "br i1 " + rir.result + ", label %whileout" + whileCount + ", " + "%whilein" + whileCount + "\n";
        ir += s + "whilein" + whileCount + ":\n";
        ir += block.toIR(n + 4);
        ir += s + "br label %while" + whileCount + "\n";
        ir += s + "whileout" + whileCount + ":\n";

        return new LlvmIR(
                ir, ""
        );
    }
}
