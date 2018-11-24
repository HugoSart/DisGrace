package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Block;
import com.hugovs.jps.structure.semanthic.Expression;

public class IfCommand extends Command {

    private Expression expression;
    private ElseCommand elseCommand;

    private Block block;

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
}
