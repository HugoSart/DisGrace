package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.llvm.LlvmRepresentable;
import com.hugovs.jps.structure.llvm.LlvmUtil;

public class Value implements LlvmRepresentable {

    private Type type;
    private Object value = null;

    public Value() {}

    public Value(Type type, Object value) {this.type=type; this.value=value;}

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getVarValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<type=" + type + ", value=" + value + ">";
    }

    public LlvmIR valueIR(int n) {
        String s = Util.spaces(n);
        if (value == null) return new LlvmIR("", "null");
        if (value instanceof Integer) return new LlvmIR("", value.toString());
        if (value instanceof Boolean) return new LlvmIR("", (Boolean)value ? "true" : "false");
        if (value instanceof String) return new LlvmIR("", "getelementptr [" + (((String) value).length() + 1) + " x i8]* c\"" + ((String) value).replace('\"', ' ') + "\\A0\00\", i64 0, i64 0");
        if (value instanceof Variable) return ((Variable) value).toIR(0);
        if (value instanceof Subprogram) {
            Subprogram sub = (Subprogram)value;
            String param = "";
            String paramDef = "";
            for (Value parameter : sub.arguments) {
                LlvmIR ir = parameter.toIR();
                paramDef += s + ir.code + "\n";
                param += parameter.getType().llvmCode + " " + ir.result;
            }

            return new LlvmIR(paramDef, "call " + sub.getReturnType().llvmCode + " @" + sub.getId() + "(" + param + ")");
        }
        return new LlvmIR("", "???");
    }

    @Override
    public LlvmIR toIR(int ident) {
        String s = Util.spaces(ident);
        System.out.println(value instanceof LlvmRepresentable);
        int r;
        LlvmIR ir = valueIR(ident);
        return new LlvmIR(s + ir.code + s + "%r" + (r = LlvmUtil.rCount++) + " = " + ir.result + "\n", "%r" + r);
    }

}
