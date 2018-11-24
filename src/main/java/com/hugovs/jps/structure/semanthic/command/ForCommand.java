package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Block;

import java.util.List;

public class ForCommand extends Command {

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
}
