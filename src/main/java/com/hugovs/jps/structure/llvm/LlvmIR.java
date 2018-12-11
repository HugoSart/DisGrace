package com.hugovs.jps.structure.llvm;

public class LlvmIR {

    public final String code;
    public final String result;

    public LlvmIR(String code, String result) {
        this.code = code;
        this.result = result;
    }

    @Override
    public String toString() {
        return code;
    }
}
