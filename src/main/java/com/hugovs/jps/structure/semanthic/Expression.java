package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.llvm.LlvmIR;
import com.hugovs.jps.structure.llvm.LlvmRepresentable;
import com.hugovs.jps.structure.exception.IncompatibleTypeException;
import com.hugovs.jps.structure.llvm.LlvmUtil;
import com.hugovs.jps.structure.semanthic.operation.Operation;

public class Expression extends Value implements LlvmRepresentable {

    private boolean singleton = false;
    private Operation operation;

    public void addOperation(Operation op) {
        if (op.getType() != getType()) throw new IncompatibleTypeException(getType(), op.getType());
        operation = op;
    }

    public void setOperation(Operation op) {
        this.operation = op;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setSingleton(boolean b) {
        this.singleton = b;
    }

    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public String toString() {
        //return getClass().getSimpleName() + "<singleton=" + singleton + ", operation=" + operation + ", value=" + getVarValue() + ">";
        return "Expression";
    }

    @Override
    public LlvmIR toIR(int ident) {
        String s = Util.spaces(ident);
        int r;
        if (singleton)
            if (getVarValue() instanceof LlvmRepresentable)
                return ((LlvmRepresentable) getVarValue()).toIR();
            else return new LlvmIR(s + "%r" + (r = LlvmUtil.rCount++) + " = " + getVarValue().toString() + "\n", "%r" + r);
        return operation.toIR(ident);
    }

}
