package com.hugovs.jps.structure.semanthic;

public enum Type {
    INT("i32", 0), BOOL("i1", false), STRING("i8*", ""), VOID("void", null);

    public final String llvmCode;
    public final Object def;

    Type(String llvmCode, Object def) {
        this.llvmCode = llvmCode;
        this.def = def;
    }

}
