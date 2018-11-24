package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Block;

public class ElseCommand extends Command {
    private IfCommand ifCommand;
    private Block block;

    public IfCommand getIfCommand() {
        return ifCommand;
    }

    public void setIfCommand(IfCommand ifCommand) {
        this.ifCommand = ifCommand;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
