package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.semanthic.Block;
import com.hugovs.jps.structure.semanthic.Expression;
import com.hugovs.jps.structure.semanthic.Util;

import java.util.List;

public class ForCommand extends Command {

    private static int forCountGlobal = 0;
    private int forCount = forCountGlobal++;
    private Expression condition;

    private List<AttributionCommand> firstAttributionCommands, secondAttributionCommands;
    private Block block;

    public List<AttributionCommand> getFirstAttributionCommands() {
        return firstAttributionCommands;
    }

    public void setFirstAttributionCommands(List<AttributionCommand> firstAttributionCommands) {
        this.firstAttributionCommands = firstAttributionCommands;
    }

    public List<AttributionCommand> getSecondAttributionCommands() {
        return secondAttributionCommands;
    }

    public void setSecondAttributionCommands(List<AttributionCommand> secondAttributionCommands) {
        this.secondAttributionCommands = secondAttributionCommands;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    @Override
    public LlvmIR toIR(int n) {

        block.inLabel.value = "for" + forCount;
        block.outLabel.value = "forout" + forCount;

        String s = Util.spaces(n);
        String ir = "\n" + s + "; ForCommand\n";

        for (AttributionCommand firstAttributionCommand : firstAttributionCommands)
            ir += firstAttributionCommand.toIR(n + 4);

        ir += "\n";
        ir += s + "for" + forCount + ":\n";

        LlvmIR condIr = condition.toIR(n + 4);
        ir += condIr;

        ir += s + "br i1 " + condIr.result + ", label %forin" + forCount + ", " + "%forout" + forCount + "\n";
        ir += s + "forin" + forCount + ":\n";
        ir += block.toIR(n + 4);

        for (AttributionCommand secondAttributionCommand : secondAttributionCommands)
            ir += secondAttributionCommand.toIR(n + 4);

        ir += "\n";
        ir += s + "br label %for" + forCount + "\n";
        ir += "\n";
        ir += s + "forout" + forCount + ":\n";

        return new LlvmIR(
                ir, ""
        );
    }
}
