package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.llvm.LlvmRepresentable;
import com.hugovs.jps.structure.semanthic.Block;

public abstract class Command implements LlvmRepresentable {
    public Block block;
}
